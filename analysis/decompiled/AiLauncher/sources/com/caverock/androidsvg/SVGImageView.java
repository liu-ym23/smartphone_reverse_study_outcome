package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions;
    private SVG svg;

    public class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        public LoadResourceTask(Context context, int i10) {
            this.context = context;
            this.resourceId = i10;
        }

        @Override // android.os.AsyncTask
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e10) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.resourceId), e10.getMessage()));
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    public class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        @Override // android.os.AsyncTask
        public SVG doInBackground(InputStream... inputStreamArr) throws IOException {
            try {
                try {
                    return SVG.getFromInputStream(inputStreamArr[0]);
                } catch (SVGParseException e10) {
                    Log.e("SVGImageView", "Parse error loading URI: " + e10.getMessage());
                    try {
                        inputStreamArr[0].close();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                }
            } finally {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused2) {
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    static {
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
        this.svg = null;
        this.renderOptions = new RenderOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRender() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SVG svg = this.svg;
        if (svg == null) {
            return;
        }
        Picture pictureRenderToPicture = svg.renderToPicture(this.renderOptions);
        setSoftwareLayerType();
        setImageDrawable(new PictureDrawable(pictureRenderToPicture));
    }

    private void init(AttributeSet attributeSet, int i10) {
        if (isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i10, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.SVGImageView_css);
            if (string != null) {
                this.renderOptions.css(string);
            }
            int i11 = R.styleable.SVGImageView_svg;
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(i11, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            String string2 = typedArrayObtainStyledAttributes.getString(i11);
            if (string2 != null) {
                if (internalSetImageURI(Uri.parse(string2))) {
                    typedArrayObtainStyledAttributes.recycle();
                    return;
                } else {
                    if (internalSetImageAsset(string2)) {
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                    setFromString(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private boolean internalSetImageAsset(String str) throws IOException {
        try {
            new LoadURITask().execute(getContext().getAssets().open(str));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean internalSetImageURI(Uri uri) throws FileNotFoundException {
        try {
            new LoadURITask().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private void setFromString(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.svg = SVG.getFromString(str);
            doRender();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    private void setSoftwareLayerType() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            setLayerTypeMethod.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e10) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e10);
        }
    }

    public void setCSS(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.renderOptions.css(str);
        doRender();
    }

    public void setImageAsset(String str) {
        if (internalSetImageAsset(str)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        new LoadResourceTask(getContext(), i10).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (internalSetImageURI(uri)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + uri);
    }

    public void setSVG(SVG svg) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.svg = svg;
        doRender();
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, 0);
    }

    public void setSVG(SVG svg, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (svg != null) {
            this.svg = svg;
            this.renderOptions.css(str);
            doRender();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attributeSet, i10);
    }
}
