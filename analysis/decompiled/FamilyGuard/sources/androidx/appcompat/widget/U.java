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
import g.C0728a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
class U extends H.c implements View.OnClickListener {

    /* renamed from: l, reason: collision with root package name */
    private final SearchView f8425l;

    /* renamed from: m, reason: collision with root package name */
    private final SearchableInfo f8426m;

    /* renamed from: n, reason: collision with root package name */
    private final Context f8427n;

    /* renamed from: o, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f8428o;

    /* renamed from: p, reason: collision with root package name */
    private final int f8429p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8430q;

    /* renamed from: r, reason: collision with root package name */
    private int f8431r;

    /* renamed from: s, reason: collision with root package name */
    private ColorStateList f8432s;

    /* renamed from: t, reason: collision with root package name */
    private int f8433t;

    /* renamed from: u, reason: collision with root package name */
    private int f8434u;

    /* renamed from: v, reason: collision with root package name */
    private int f8435v;

    /* renamed from: w, reason: collision with root package name */
    private int f8436w;

    /* renamed from: x, reason: collision with root package name */
    private int f8437x;

    /* renamed from: y, reason: collision with root package name */
    private int f8438y;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f8439a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f8440b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f8441c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f8442d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f8443e;

        public a(View view) {
            this.f8439a = (TextView) view.findViewById(R.id.text1);
            this.f8440b = (TextView) view.findViewById(R.id.text2);
            this.f8441c = (ImageView) view.findViewById(R.id.icon1);
            this.f8442d = (ImageView) view.findViewById(R.id.icon2);
            this.f8443e = (ImageView) view.findViewById(g.f.f16935q);
        }
    }

    public U(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f8430q = false;
        this.f8431r = 1;
        this.f8433t = -1;
        this.f8434u = -1;
        this.f8435v = -1;
        this.f8436w = -1;
        this.f8437x = -1;
        this.f8438y = -1;
        this.f8425l = searchView;
        this.f8426m = searchableInfo;
        this.f8429p = searchView.getSuggestionCommitIconResId();
        this.f8427n = context;
        this.f8428o = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f8428o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f8432s == null) {
            TypedValue typedValue = new TypedValue();
            this.f8427n.getTheme().resolveAttribute(C0728a.f16820Q, typedValue, true);
            this.f8432s = this.f8427n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f8432s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.f8427n.getPackageManager();
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
        } catch (PackageManager.NameNotFoundException e6) {
            Log.w("SuggestionsAdapter", e6.toString());
            return null;
        }
    }

    private Drawable m(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f8428o.containsKey(strFlattenToShortString)) {
            Drawable drawableL = l(componentName);
            this.f8428o.put(strFlattenToShortString, drawableL != null ? drawableL.getConstantState() : null);
            return drawableL;
        }
        Drawable.ConstantState constantState = this.f8428o.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f8427n.getResources());
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() throws PackageManager.NameNotFoundException {
        Drawable drawableM = m(this.f8426m.getSearchActivity());
        return drawableM != null ? drawableM : this.f8427n.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable p(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f8427n.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    return drawableCreateFromStream;
                } catch (IOException e6) {
                    return drawableCreateFromStream;
                }
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e62) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e62);
                }
            }
        } catch (FileNotFoundException e7) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e7.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e7.getMessage());
        return null;
    }

    private Drawable r(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i5 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f8427n.getPackageName() + "/" + i5;
            Drawable drawableJ = j(str2);
            if (drawableJ != null) {
                return drawableJ;
            }
            Drawable drawableE = androidx.core.content.a.e(this.f8427n, i5);
            z(str2, drawableE);
            return drawableE;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableJ2 = j(str);
            if (drawableJ2 != null) {
                return drawableJ2;
            }
            Drawable drawableP = p(Uri.parse(str));
            z(str, drawableP);
            return drawableP;
        }
    }

    private Drawable s(Cursor cursor) throws NumberFormatException, IOException {
        int i5 = this.f8436w;
        if (i5 == -1) {
            return null;
        }
        Drawable drawableR = r(cursor.getString(i5));
        return drawableR != null ? drawableR : o();
    }

    private Drawable t(Cursor cursor) {
        int i5 = this.f8437x;
        if (i5 == -1) {
            return null;
        }
        return r(cursor.getString(i5));
    }

    private static String v(Cursor cursor, int i5) {
        if (i5 == -1) {
            return null;
        }
        try {
            return cursor.getString(i5);
        } catch (Exception e6) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e6);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i5) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i5);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f8428o.put(str, drawable.getConstantState());
        }
    }

    @Override // H.a, H.b.a
    public void a(Cursor cursor) {
        if (this.f8430q) {
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
                this.f8433t = cursor.getColumnIndex("suggest_text_1");
                this.f8434u = cursor.getColumnIndex("suggest_text_2");
                this.f8435v = cursor.getColumnIndex("suggest_text_2_url");
                this.f8436w = cursor.getColumnIndex("suggest_icon_1");
                this.f8437x = cursor.getColumnIndex("suggest_icon_2");
                this.f8438y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e6) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e6);
        }
    }

    @Override // H.b.a
    public Cursor c(CharSequence charSequence) {
        String string = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f8425l.getVisibility() == 0 && this.f8425l.getWindowVisibility() == 0) {
            try {
                Cursor cursorU = u(this.f8426m, string, 50);
                if (cursorU != null) {
                    cursorU.getCount();
                    return cursorU;
                }
            } catch (RuntimeException e6) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e6);
            }
        }
        return null;
    }

    @Override // H.b.a
    public CharSequence convertToString(Cursor cursor) {
        String strN;
        String strN2;
        if (cursor == null) {
            return null;
        }
        String strN3 = n(cursor, "suggest_intent_query");
        if (strN3 != null) {
            return strN3;
        }
        if (this.f8426m.shouldRewriteQueryFromData() && (strN2 = n(cursor, "suggest_intent_data")) != null) {
            return strN2;
        }
        if (!this.f8426m.shouldRewriteQueryFromText() || (strN = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strN;
    }

    @Override // H.a
    public void d(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i5 = this.f8438y;
        int i6 = i5 != -1 ? cursor.getInt(i5) : 0;
        if (aVar.f8439a != null) {
            y(aVar.f8439a, v(cursor, this.f8433t));
        }
        if (aVar.f8440b != null) {
            String strV = v(cursor, this.f8435v);
            CharSequence charSequenceK = strV != null ? k(strV) : v(cursor, this.f8434u);
            if (TextUtils.isEmpty(charSequenceK)) {
                TextView textView = aVar.f8439a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f8439a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f8439a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f8439a.setMaxLines(1);
                }
            }
            y(aVar.f8440b, charSequenceK);
        }
        ImageView imageView = aVar.f8441c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = aVar.f8442d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i7 = this.f8431r;
        if (i7 != 2 && (i7 != 1 || (i6 & 1) == 0)) {
            aVar.f8443e.setVisibility(8);
            return;
        }
        aVar.f8443e.setVisibility(0);
        aVar.f8443e.setTag(aVar.f8439a.getText());
        aVar.f8443e.setOnClickListener(this);
    }

    @Override // H.c, H.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewG = super.g(context, cursor, viewGroup);
        viewG.setTag(new a(viewG));
        ((ImageView) viewG.findViewById(g.f.f16935q)).setImageResource(this.f8429p);
        return viewG;
    }

    @Override // H.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i5, view, viewGroup);
        } catch (RuntimeException e6) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e6);
            View viewF = this.f(this.f8427n, this.b(), viewGroup);
            if (viewF != null) {
                ((a) viewF.getTag()).f8439a.setText(e6.toString());
            }
            return viewF;
        }
    }

    @Override // H.a, android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i5, view, viewGroup);
        } catch (RuntimeException e6) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e6);
            View viewG = this.g(this.f8427n, this.b(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f8439a.setText(e6.toString());
            }
            return viewG;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f8425l.M((CharSequence) tag);
        }
    }

    Drawable q(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f8427n.getPackageManager().getResourcesForApplication(authority);
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

    Cursor u(SearchableInfo searchableInfo, String str, int i5) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
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
        if (i5 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i5));
        }
        return this.f8427n.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void w(int i5) {
        this.f8431r = i5;
    }
}
