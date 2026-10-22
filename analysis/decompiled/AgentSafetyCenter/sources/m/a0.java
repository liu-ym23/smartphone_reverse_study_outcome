package m;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class a0 implements t0 {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7867d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7868a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final View f7869b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7870c;

    public a0(EditText editText) {
        this.f7869b = editText;
        int i = 2;
        a2.i iVar = new a2.i(i);
        p5.u uVar = new p5.u(i);
        uVar.f9807f = editText;
        c4.i iVar2 = new c4.i();
        iVar2.f2203c = editText;
        iVar2.f2205g = true;
        VarHandle.storeStoreFence();
        uVar.f9808g = iVar2;
        editText.addTextChangedListener(iVar2);
        if (c4.a.f2190b == null) {
            synchronized (c4.a.f2189a) {
                try {
                    if (c4.a.f2190b == null) {
                        c4.a aVar = new c4.a();
                        try {
                            c4.a.f2191c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, c4.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        c4.a.f2190b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(c4.a.f2190b);
        VarHandle.storeStoreFence();
        iVar.f49f = uVar;
        VarHandle.storeStoreFence();
        this.f7870c = iVar;
    }

    public KeyListener b(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((p5.u) ((a2.i) this.f7870c).f49f).getClass();
        if (keyListener instanceof c4.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        c4.e eVar = new c4.e();
        eVar.f2198a = keyListener;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public void c(AttributeSet attributeSet, int i) {
        int i3 = this.f7868a;
        View view = this.f7869b;
        switch (i3) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) view;
                p5.m mVarJ = p5.m.J(absSeekBar.getContext(), attributeSet, f7867d, i);
                Drawable drawableB = mVarJ.B(0);
                if (drawableB != null) {
                    if (drawableB instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableB;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable drawableF = f(animationDrawable.getFrame(i10), true);
                            drawableF.setLevel(10000);
                            animationDrawable2.addFrame(drawableF, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableB = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableB);
                }
                Drawable drawableB2 = mVarJ.B(1);
                if (drawableB2 != null) {
                    absSeekBar.setProgressDrawable(f(drawableB2, false));
                }
                mVarJ.M();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) view).getContext().obtainStyledAttributes(attributeSet, g.a.i, i, 0);
                try {
                    boolean z10 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
                    typedArrayObtainStyledAttributes.recycle();
                    e(z10);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public c4.b d(InputConnection inputConnection, EditorInfo editorInfo) {
        InputConnection inputConnection2;
        a2.i iVar = (a2.i) this.f7870c;
        if (inputConnection == null) {
            iVar.getClass();
            inputConnection2 = null;
        } else {
            p5.u uVar = (p5.u) iVar.f49f;
            uVar.getClass();
            if (!(inputConnection instanceof c4.b)) {
                EditText editText = (EditText) uVar.f9807f;
                f7.f fVar = new f7.f(20);
                c4.b bVar = new c4.b(inputConnection, false);
                bVar.f2192a = editText;
                bVar.f2193b = fVar;
                if (a4.j.c()) {
                    a4.j jVarA = a4.j.a();
                    if (jVarA.b() == 1 && editorInfo != null) {
                        if (editorInfo.extras == null) {
                            editorInfo.extras = new Bundle();
                        }
                        a4.e eVar = jVarA.f179e;
                        eVar.getClass();
                        Bundle bundle = editorInfo.extras;
                        b4.b bVar2 = (b4.b) eVar.f166c.f9730c;
                        int iA = bVar2.a(4);
                        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar2.f1900h).getInt(iA + bVar2.f1897c) : 0);
                        editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
                    }
                }
                VarHandle.storeStoreFence();
                inputConnection = bVar;
            }
            inputConnection2 = inputConnection;
        }
        return (c4.b) inputConnection2;
    }

    public void e(boolean z10) {
        c4.i iVar = (c4.i) ((p5.u) ((a2.i) this.f7870c).f49f).f9808g;
        if (iVar.f2205g != z10) {
            if (iVar.f2204f != null) {
                a4.j jVarA = a4.j.a();
                c4.h hVar = iVar.f2204f;
                jVarA.getClass();
                p5.f.k(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = jVarA.f175a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    jVarA.f176b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f2205g = z10;
            if (z10) {
                c4.i.a(iVar.f2203c, a4.j.a().b());
            }
        }
    }

    public Drawable f(Drawable drawable, boolean z10) {
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.f7870c) == null) {
                this.f7870c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z10 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id2 = layerDrawable.getId(i);
            drawableArr[i] = f(layerDrawable.getDrawable(i), id2 == 16908301 || id2 == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            layerDrawable2.setId(i3, layerDrawable.getId(i3));
            layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
            layerDrawable2.setLayerWidth(i3, layerDrawable.getLayerWidth(i3));
            layerDrawable2.setLayerHeight(i3, layerDrawable.getLayerHeight(i3));
            layerDrawable2.setLayerInsetLeft(i3, layerDrawable.getLayerInsetLeft(i3));
            layerDrawable2.setLayerInsetRight(i3, layerDrawable.getLayerInsetRight(i3));
            layerDrawable2.setLayerInsetTop(i3, layerDrawable.getLayerInsetTop(i3));
            layerDrawable2.setLayerInsetBottom(i3, layerDrawable.getLayerInsetBottom(i3));
            layerDrawable2.setLayerInsetStart(i3, layerDrawable.getLayerInsetStart(i3));
            layerDrawable2.setLayerInsetEnd(i3, layerDrawable.getLayerInsetEnd(i3));
        }
        return layerDrawable2;
    }

    @Override // m.t0
    public void a(int i, float f5) {
    }

    public a0(AbsSeekBar absSeekBar) {
        this.f7869b = absSeekBar;
    }

    public a0(v0 v0Var) {
        this.f7870c = v0Var;
        this.f7869b = v0Var;
    }
}
