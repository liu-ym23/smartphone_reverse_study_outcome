package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import com.stepos.ame.sdk.SkillStoreKt;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class N extends F0.c implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    public final SearchView f8990l;

    /* renamed from: m, reason: collision with root package name */
    public final SearchableInfo f8991m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f8992n;

    /* renamed from: o, reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f8993o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8994p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8995q;

    /* renamed from: r, reason: collision with root package name */
    public int f8996r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f8997s;

    /* renamed from: t, reason: collision with root package name */
    public int f8998t;

    /* renamed from: u, reason: collision with root package name */
    public int f8999u;

    /* renamed from: v, reason: collision with root package name */
    public int f9000v;

    /* renamed from: w, reason: collision with root package name */
    public int f9001w;

    /* renamed from: x, reason: collision with root package name */
    public int f9002x;

    /* renamed from: y, reason: collision with root package name */
    public int f9003y;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f9004a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f9005b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f9006c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f9007d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f9008e;

        public a(View view) {
            this.f9004a = (TextView) view.findViewById(R.id.text1);
            this.f9005b = (TextView) view.findViewById(R.id.text2);
            this.f9006c = (ImageView) view.findViewById(R.id.icon1);
            this.f9007d = (ImageView) view.findViewById(R.id.icon2);
            this.f9008e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public N(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f8995q = false;
        this.f8996r = 1;
        this.f8998t = -1;
        this.f8999u = -1;
        this.f9000v = -1;
        this.f9001w = -1;
        this.f9002x = -1;
        this.f9003y = -1;
        this.f8990l = searchView;
        this.f8991m = searchableInfo;
        this.f8994p = searchView.getSuggestionCommitIconResId();
        this.f8992n = context;
        this.f8993o = weakHashMap;
    }

    public static String m(Cursor cursor, String str) {
        return u(cursor, cursor.getColumnIndex(str));
    }

    public static String u(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    @Override // F0.a, F0.b.a
    public void a(Cursor cursor) {
        if (this.f8995q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f8998t = cursor.getColumnIndex("suggest_text_1");
                this.f8999u = cursor.getColumnIndex("suggest_text_2");
                this.f9000v = cursor.getColumnIndex("suggest_text_2_url");
                this.f9001w = cursor.getColumnIndex("suggest_icon_1");
                this.f9002x = cursor.getColumnIndex("suggest_icon_2");
                this.f9003y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    @Override // F0.b.a
    public Cursor b(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f8990l.getVisibility() == 0 && this.f8990l.getWindowVisibility() == 0) {
            try {
                Cursor cursorT = t(this.f8991m, string, 50);
                if (cursorT != null) {
                    cursorT.getCount();
                    return cursorT;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }

    @Override // F0.a
    public void c(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i10 = this.f9003y;
        int i11 = i10 != -1 ? cursor.getInt(i10) : 0;
        if (aVar.f9004a != null) {
            x(aVar.f9004a, u(cursor, this.f8998t));
        }
        if (aVar.f9005b != null) {
            String strU = u(cursor, this.f9000v);
            CharSequence charSequenceJ = strU != null ? j(strU) : u(cursor, this.f8999u);
            if (TextUtils.isEmpty(charSequenceJ)) {
                TextView textView = aVar.f9004a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f9004a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f9004a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f9004a.setMaxLines(1);
                }
            }
            x(aVar.f9005b, charSequenceJ);
        }
        ImageView imageView = aVar.f9006c;
        if (imageView != null) {
            w(imageView, r(cursor), 4);
        }
        ImageView imageView2 = aVar.f9007d;
        if (imageView2 != null) {
            w(imageView2, s(cursor), 8);
        }
        int i12 = this.f8996r;
        if (i12 != 2 && (i12 != 1 || (i11 & 1) == 0)) {
            aVar.f9008e.setVisibility(8);
            return;
        }
        aVar.f9008e.setVisibility(0);
        aVar.f9008e.setTag(aVar.f9004a.getText());
        aVar.f9008e.setOnClickListener(this);
    }

    @Override // F0.b.a
    public CharSequence convertToString(Cursor cursor) {
        String strM;
        String strM2;
        if (cursor == null) {
            return null;
        }
        String strM3 = m(cursor, "suggest_intent_query");
        if (strM3 != null) {
            return strM3;
        }
        if (this.f8991m.shouldRewriteQueryFromData() && (strM2 = m(cursor, "suggest_intent_data")) != null) {
            return strM2;
        }
        if (!this.f8991m.shouldRewriteQueryFromText() || (strM = m(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM;
    }

    @Override // F0.c, F0.a
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewF = super.f(context, cursor, viewGroup);
        viewF.setTag(new a(viewF));
        ((ImageView) viewF.findViewById(R$id.edit_query)).setImageResource(this.f8994p);
        return viewF;
    }

    @Override // F0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewE = this.e(this.f8992n, this.getCursor(), viewGroup);
            if (viewE != null) {
                ((a) viewE.getTag()).f9004a.setText(e10.toString());
            }
            return viewE;
        }
    }

    @Override // F0.a, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View viewF = this.f(this.f8992n, this.getCursor(), viewGroup);
            if (viewF != null) {
                ((a) viewF.getTag()).f9004a.setText(e10.toString());
            }
            return viewF;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable i(String str) {
        Drawable.ConstantState constantState = this.f8993o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence j(CharSequence charSequence) {
        if (this.f8997s == null) {
            TypedValue typedValue = new TypedValue();
            this.f8992n.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f8997s = this.f8992n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f8997s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable k(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f8992n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    public final Drawable l(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f8993o.containsKey(strFlattenToShortString)) {
            Drawable drawableK = k(componentName);
            this.f8993o.put(strFlattenToShortString, drawableK != null ? drawableK.getConstantState() : null);
            return drawableK;
        }
        Drawable.ConstantState constantState = this.f8993o.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f8992n.getResources());
    }

    public final Drawable n() throws PackageManager.NameNotFoundException {
        Drawable drawableL = l(this.f8991m.getSearchActivity());
        return drawableL != null ? drawableL : this.f8992n.getPackageManager().getDefaultActivityIcon();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        z(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        z(getCursor());
    }

    public final Drawable o(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return p(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f8992n.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    return drawableCreateFromStream;
                } catch (IOException e10) {
                    return drawableCreateFromStream;
                }
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e102) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e102);
                }
            }
        } catch (FileNotFoundException e11) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e11.getMessage());
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f8990l.r((CharSequence) tag);
        }
    }

    public Drawable p(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f8992n.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable q(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i10 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f8992n.getPackageName() + "/" + i10;
            Drawable drawableI = i(str2);
            if (drawableI != null) {
                return drawableI;
            }
            Drawable drawableE = androidx.core.content.a.e(this.f8992n, i10);
            y(str2, drawableE);
            return drawableE;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableI2 = i(str);
            if (drawableI2 != null) {
                return drawableI2;
            }
            Drawable drawableO = o(Uri.parse(str));
            y(str, drawableO);
            return drawableO;
        }
    }

    public final Drawable r(Cursor cursor) throws NumberFormatException, IOException {
        int i10 = this.f9001w;
        if (i10 == -1) {
            return null;
        }
        Drawable drawableQ = q(cursor.getString(i10));
        return drawableQ != null ? drawableQ : n();
    }

    public final Drawable s(Cursor cursor) {
        int i10 = this.f9002x;
        if (i10 == -1) {
            return null;
        }
        return q(cursor.getString(i10));
    }

    public Cursor t(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme(SkillStoreKt.SKILL_DOC_TYPE_CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f8992n.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void v(int i10) {
        this.f8996r = i10;
    }

    public final void w(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void x(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void y(String str, Drawable drawable) {
        if (drawable != null) {
            this.f8993o.put(str, drawable.getConstantState());
        }
    }

    public final void z(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }
}
