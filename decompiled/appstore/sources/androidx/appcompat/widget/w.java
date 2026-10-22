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
import androidx.core.content.ContextCompat;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class w extends androidx.cursoradapter.widget.b implements View.OnClickListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SearchView f1128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SearchableInfo f1129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f1130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WeakHashMap f1131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f1135s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1136t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1139w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1140x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1141y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f1142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f1144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f1145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f1146e;

        public a(View r10) {
            this.f1142a = (TextView) r10.findViewById(R.id.text1);
            this.f1143b = (TextView) r10.findViewById(R.id.text2);
            this.f1144c = (ImageView) r10.findViewById(R.id.icon1);
            this.f1145d = (ImageView) r10.findViewById(R.id.icon2);
            this.f1146e = (ImageView) r10.findViewById(R$id.edit_query);
        }
    }

    public w(Context r10, SearchView r11, SearchableInfo r12, WeakHashMap r13) {
        super(r10, r11.getSuggestionRowLayout(), null, true);
        this.f1133q = false;
        this.f1134r = 1;
        this.f1136t = -1;
        this.f1137u = -1;
        this.f1138v = -1;
        this.f1139w = -1;
        this.f1140x = -1;
        this.f1141y = -1;
        this.f1128l = r11;
        this.f1129m = r12;
        this.f1132p = r11.getSuggestionCommitIconResId();
        this.f1130n = r10;
        this.f1131o = r13;
    }

    public static String k(Cursor r10, String r11) {
        return s(r10, r10.getColumnIndex(r11));
    }

    public static String s(Cursor r10, int r11) {
        if (r11 != (-1)) goto L10;
        return null;
    L10:
        return r10.getString(r11);
    L7:
        e = move-exception;
        Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    @Override // androidx.cursoradapter.widget.a
    public void a(View r10, Context r11, Cursor r12) {
        a r13 = (a) r10.getTag();
        int r14 = this.f1141y;
        if (r14 == (-1)) goto L5;
        int r15 = r12.getInt(r14);
    L7:
        if (r13.f1142a == null) goto L10;
        v(r13.f1142a, s(r12, this.f1136t));
    L10:
        if (r13.f1143b == null) goto L24;
        String r16 = s(r12, this.f1138v);
        if (r16 == null) goto L14;
        CharSequence r17 = h(r16);
    L16:
        if (TextUtils.isEmpty(r17) == false) goto L20;
        TextView r18 = r13.f1142a;
        if (r18 == null) goto L23;
        r18.setSingleLine(false);
        r13.f1142a.setMaxLines(2);
    L23:
        v(r13.f1143b, r17);
        goto L24
    L20:
        TextView r19 = r13.f1142a;
        if (r19 == null) goto L23;
        r19.setSingleLine(true);
        r13.f1142a.setMaxLines(1);
        goto L23
    L14:
        r17 = s(r12, this.f1137u);
    L24:
        ImageView r20 = r13.f1144c;
        if (r20 == null) goto L27;
        u(r20, p(r12), 4);
    L27:
        ImageView r21 = r13.f1145d;
        if (r21 == null) goto L30;
        u(r21, q(r12), 8);
    L30:
        int r22 = this.f1134r;
        if (r22 == 2) goto L37;
        if (r22 == 1) goto L34;
    L36:
        r13.f1146e.setVisibility(8);
        return;
    L34:
        if ((r15 & 1) == 0) goto L36;
    L37:
        r13.f1146e.setVisibility(0);
        r13.f1146e.setTag(r13.f1142a.getText());
        r13.f1146e.setOnClickListener(this);
        return;
    L5:
        r15 = 0;
        goto L7
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r10) {
        if (this.f1133q == false) goto L15;
        Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
        if (r10 == null) goto L17;
        r10.close();
        return;
    L17:
        return;
    L15:
        super.changeCursor(r10);     // Catch: Exception -> L12
        if (r10 == null) goto L18;
        this.f1136t = r10.getColumnIndex("suggest_text_1");     // Catch: Exception -> L12
        this.f1137u = r10.getColumnIndex("suggest_text_2");     // Catch: Exception -> L12
        this.f1138v = r10.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L12
        this.f1139w = r10.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L12
        this.f1140x = r10.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L12
        this.f1141y = r10.getColumnIndex("suggest_flags");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = k(r10, "suggest_intent_query");
        if (r11 == null) goto L9;
        return r11;
    L9:
        if (this.f1129m.shouldRewriteQueryFromData() == false) goto L14;
        String r12 = k(r10, "suggest_intent_data");
        if (r12 == null) goto L14;
        return r12;
    L14:
        if (this.f1129m.shouldRewriteQueryFromText() == false) goto L18;
        String r13 = k(r10, "suggest_text_1");
        if (r13 == null) goto L18;
        return r13;
    L18:
        return null;
    }

    @Override // androidx.cursoradapter.widget.b, androidx.cursoradapter.widget.a
    public View d(Context r10, Cursor r11, ViewGroup r12) {
        View r13 = super.d(r10, r11, r12);
        r13.setTag(new a(r13));
        ((ImageView) r13.findViewById(R$id.edit_query)).setImageResource(this.f1132p);
        return r13;
    }

    public final Drawable g(String r10) {
        Drawable.ConstantState r11 = (Drawable.ConstantState) this.f1131o.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.newDrawable();
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r10, View r11, ViewGroup r12) {
        return super.getDropDownView(r10, r11, r12);
    L4:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
        View r13 = c(this.f1130n, getCursor(), r12);
        if (r13 == null) goto L8;
        ((a) r13.getTag()).f1142a.setText(e.toString());
    L8:
        return r13;
    }

    @Override // androidx.cursoradapter.widget.a, android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        return super.getView(r10, r11, r12);
    L4:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
        View r13 = d(this.f1130n, getCursor(), r12);
        if (r13 == null) goto L8;
        ((a) r13.getTag()).f1142a.setText(e.toString());
    L8:
        return r13;
    }

    public final CharSequence h(CharSequence r10) {
        if (this.f1135s != null) goto L5;
        TypedValue r11 = new TypedValue();
        this.f1130n.getTheme().resolveAttribute(R$attr.textColorSearchUrl, r11, true);
        this.f1135s = this.f1130n.getResources().getColorStateList(r11.resourceId);
    L5:
        SpannableString r12 = new SpannableString(r10);
        r12.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1135s, null), 0, r10.length(), 33);
        return r12;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable i(ComponentName r10) {
        PackageManager r11 = this.f1130n.getPackageManager();
        ActivityInfo r12 = r11.getActivityInfo(r10, 128);     // Catch: PackageManager.NameNotFoundException -> L12
        int r13 = r12.getIconResource();
        if (r13 != 0) goto L7;
        return null;
    L7:
        Drawable r14 = r11.getDrawable(r10.getPackageName(), r13, r12.applicationInfo);
        if (r14 != null) goto L11;
        Log.w("SuggestionsAdapter", "Invalid icon resource " + r13 + " for " + r10.flattenToShortString());
        return null;
    L11:
        return r14;
    L12:
        e = move-exception;
        Log.w("SuggestionsAdapter", e.toString());
        return null;
    }

    public final Drawable j(ComponentName r10) {
        String r11 = r10.flattenToShortString();
        Drawable.ConstantState r12 = null;
        if (this.f1131o.containsKey(r11) == false) goto L9;
        Drawable.ConstantState r13 = (Drawable.ConstantState) this.f1131o.get(r11);
        if (r13 != null) goto L8;
        return null;
    L8:
        return r13.newDrawable(this.f1130n.getResources());
    L9:
        Drawable r14 = i(r10);
        if (r14 == null) goto L13;
        r12 = r14.getConstantState();
    L13:
        this.f1131o.put(r11, r12);
        return r14;
    }

    public final Drawable l() {
        Drawable r10 = j(this.f1129m.getSearchActivity());
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.f1130n.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable m(Uri r10) {
    L7:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Icon not found: " + r10 + ", " + e.getMessage());
        return null;
    L4:
        if ("android.resource".equals(r10.getScheme()) == true) goto L29;
        InputStream r11 = this.f1130n.getContentResolver().openInputStream(r10);     // Catch: FileNotFoundException -> L7
        if (r11 == null) goto L26;
        Drawable r12 = Drawable.createFromStream(r11, null);     // Catch: Throwable -> L19
        r11.close();     // Catch: IOException -> L16
    L18:
        return r12;
    L16:
        e = move-exception;
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L7
        goto L18
    L19:
        th = move-exception;
        r11.close();     // Catch: IOException -> L22
    L24:
        throw th;     // Catch: FileNotFoundException -> L7
    L22:
        e = move-exception;
        Log.e("SuggestionsAdapter", "Error closing icon stream for " + r10, e);     // Catch: FileNotFoundException -> L7
        goto L24
    L26:
        throw new FileNotFoundException("Failed to open " + r10);     // Catch: FileNotFoundException -> L7
    L29:
        return n(r10);
    L10:
        throw new FileNotFoundException("Resource does not exist: " + r10);     // Catch: FileNotFoundException -> L7
    }

    public Drawable n(Uri r10) {
        String r11 = r10.getAuthority();
        if (TextUtils.isEmpty(r11) == true) goto L28;
        Resources r12 = this.f1130n.getPackageManager().getResourcesForApplication(r11);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r13 = r10.getPathSegments();
        if (r13 == null) goto L24;
        int r14 = r13.size();
        if (r14 != 1) goto L14;
        int r15 = Integer.parseInt(r13.get(0));     // Catch: NumberFormatException -> L11
    L16:
        if (r15 == 0) goto L20;
        return r12.getDrawable(r15);
    L20:
        throw new FileNotFoundException("No resource found for: " + r10);
    L12:
        throw new FileNotFoundException("Single path segment is not a resource ID: " + r10);
    L14:
        if (r14 != 2) goto L22;
        r15 = r12.getIdentifier(r13.get(1), r13.get(0), r11);
        goto L16
    L22:
        throw new FileNotFoundException("More than two path segments: " + r10);
    L24:
        throw new FileNotFoundException("No path: " + r10);
    L26:
        throw new FileNotFoundException("No package found for authority: " + r10);
    L28:
        throw new FileNotFoundException("No authority: " + r10);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        x(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        x(getCursor());
    }

    public final Drawable o(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        if (AdReportParam.ClickPosType.SKIP.equals(r10) == true) goto L25;
        int r11 = Integer.parseInt(r10);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r12 = "android.resource://" + this.f1130n.getPackageName() + LibrarianImpl.Constants.SEPARATOR + r11;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r13 = g(r12);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r13 == null) goto L12;
        return r13;
    L12:
        Drawable r14 = ContextCompat.d(this.f1130n, r11);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        w(r12, r14);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r14;
    L14:
        Log.w("SuggestionsAdapter", "Icon resource not found: " + r10);
        return null;
    L16:
        Drawable r15 = g(r10);
        if (r15 == null) goto L19;
        return r15;
    L19:
        Drawable r16 = m(Uri.parse(r10));
        w(r10, r16);
        return r16;
    L25:
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        Object r11 = r10.getTag();
        if ((r11 instanceof CharSequence) == false) goto L6;
        this.f1128l.w((CharSequence) r11);
        return;
    }

    public final Drawable p(Cursor r10) {
        int r11 = this.f1139w;
        if (r11 != (-1)) goto L6;
        return null;
    L6:
        Drawable r12 = o(r10.getString(r11));
        if (r12 == null) goto L10;
        return r12;
    L10:
        return l();
    }

    public final Drawable q(Cursor r10) {
        int r11 = this.f1140x;
        if (r11 != (-1)) goto L7;
        return null;
    L7:
        return o(r10.getString(r11));
    }

    public Cursor r(SearchableInfo r10, String r11, int r12) {
        String[] r13 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r14 = r10.getSuggestAuthority();
        if (r14 != null) goto L8;
        return null;
    L8:
        Uri.Builder r15 = new Uri.Builder().scheme(ServerElements.CONTENT).authority(r14).query("").fragment("");
        String r16 = r10.getSuggestPath();
        if (r16 == null) goto L11;
        r15.appendEncodedPath(r16);
    L11:
        r15.appendPath("search_suggest_query");
        String r17 = r10.getSuggestSelection();
        if (r17 == null) goto L15;
        r13 = new String[]{r11};
    L14:
        String[] r18 = r13;
        if (r12 <= 0) goto L19;
        r15.appendQueryParameter(CommonColumns.PARAMETER_LIMIT, String.valueOf(r12));
    L19:
        return this.f1130n.getContentResolver().query(r15.build(), null, r17, r18, null);
    L15:
        r15.appendPath(r11);
        goto L14
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r10) {
        if (r10 != null) goto L4;
        String r11 = "";
    L6:
        if (this.f1128l.getVisibility() == 0) goto L8;
    L16:
        return null;
    L8:
        if (this.f1128l.getWindowVisibility() != 0) goto L16;
        Cursor r12 = r(this.f1129m, r11, 50);     // Catch: RuntimeException -> L14
        if (r12 == null) goto L16;
        r12.getCount();     // Catch: RuntimeException -> L14
        return r12;
    L14:
        e = move-exception;
        Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        goto L16
    L4:
        r11 = r10.toString();
        goto L6
    }

    public void t(int r10) {
        this.f1134r = r10;
    }

    public final void u(ImageView r10, Drawable r11, int r12) {
        r10.setImageDrawable(r11);
        if (r11 != null) goto L5;
        r10.setVisibility(r12);
        return;
    L5:
        r10.setVisibility(0);
        r11.setVisible(false, false);
        r11.setVisible(true, false);
    }

    public final void v(TextView r10, CharSequence r11) {
        r10.setText(r11);
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r10.setVisibility(8);
        return;
    L5:
        r10.setVisibility(0);
    }

    public final void w(String r10, Drawable r11) {
        if (r11 == null) goto L5;
        this.f1131o.put(r10, r11.getConstantState());
        return;
    }

    public final void x(Cursor r10) {
        if (r10 == null) goto L4;
        Bundle r11 = r10.getExtras();
    L5:
        if (r11 == null) goto L8;
        r11.getBoolean("in_progress");
        return;
    L8:
        return;
    L4:
        r11 = null;
        goto L5
    }
}
