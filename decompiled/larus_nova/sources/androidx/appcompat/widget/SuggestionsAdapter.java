package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.common.util.UriUtil;
import f06.b;
import f06.c;
import f06.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View r100) {
            this.mText1 = (TextView) r100.findViewById(R.id.text1);
            this.mText2 = (TextView) r100.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) r100.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) r100.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) r100.findViewById(com.larus.nova.R.id.edit_query);
        }
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    private Drawable getDefaultIcon1() {
        Drawable r100 = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    private Drawable checkIconCache(String r100) {
        Drawable.ConstantState r101 = this.mOutsideDrawablesCache.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.newDrawable();
    }

    private CharSequence formatUrl(CharSequence r100) {
        if (this.mUrlColor != null) goto L5;
        TypedValue r101 = new TypedValue();
        this.mProviderContext.getTheme().resolveAttribute(com.larus.nova.R.attr.textColorSearchUrl, r101, true);
        this.mUrlColor = this.mProviderContext.getResources().getColorStateList(r101.resourceId);
    L5:
        SpannableString r102 = new SpannableString(r100);
        r102.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, r100.length(), 33);
        return r102;
    }

    private Drawable getActivityIcon(ComponentName r100) {
        PackageManager r101 = this.mProviderContext.getPackageManager();
        ActivityInfo r102 = r101.getActivityInfo(r100, 128);     // Catch: PackageManager.NameNotFoundException -> L12
        int r103 = r102.getIconResource();
        if (r103 != 0) goto L7;
        return null;
    L7:
        Drawable r104 = r101.getDrawable(r100.getPackageName(), r103, r102.applicationInfo);
        if (r104 != null) goto L11;
        r100.flattenToShortString();
        return null;
    L11:
        return r104;
    L12:
        e = move-exception;
        e.toString();
        return null;
    }

    private Drawable getActivityIconWithCache(ComponentName r100) {
        String r101 = r100.flattenToShortString();
        Drawable.ConstantState r102 = null;
        if (this.mOutsideDrawablesCache.containsKey(r101) == false) goto L9;
        Drawable.ConstantState r103 = this.mOutsideDrawablesCache.get(r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.newDrawable(this.mProviderContext.getResources());
    L9:
        Drawable r104 = getActivityIcon(r100);
        if (r104 == null) goto L13;
        r102 = r104.getConstantState();
    L13:
        this.mOutsideDrawablesCache.put(r101, r102);
        return r104;
    }

    private Drawable getDrawable(Uri r100) {
    L23:
        e = move-exception;
        Objects.toString(r100);
        e.getMessage();
        return null;
    L4:
        if (UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(r100.getScheme()) == true) goto L26;
        InputStream r101 = this.mProviderContext.getContentResolver().openInputStream(r100);     // Catch: FileNotFoundException -> L23
        if (r101 == null) goto L22;
        Drawable r102 = Drawable.createFromStream(r101, null);     // Catch: Throwable -> L16
    L33:
        r101.close();     // Catch: IOException -> L14
    L15:
        return r102;
    L14:
        r100.toString();     // Catch: FileNotFoundException -> L23
    L16:
        th = move-exception;
        r101.close();     // Catch: IOException -> L19
    L20:
        throw th;     // Catch: FileNotFoundException -> L23
    L19:
        r100.toString();     // Catch: FileNotFoundException -> L23
        goto L20
    L22:
        throw new FileNotFoundException("Failed to open " + r100);     // Catch: FileNotFoundException -> L23
    L26:
        return getDrawableFromResourceUri(r100);
    L8:
        throw new FileNotFoundException("Resource does not exist: " + r100);     // Catch: FileNotFoundException -> L23
    }

    private Drawable getDrawableFromResourceValue(String r100) {
        if (r100 != null) goto L5;
    L21:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L21;
        if ("0".equals(r100) == true) goto L21;
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r102 = "android.resource://" + this.mProviderContext.getPackageName() + HTTP.URL_DEFAULT + r101;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r103 = checkIconCache(r102);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r103 == null) goto L12;
        return r103;
    L12:
        Drawable r104 = ContextCompat.getDrawable(this.mProviderContext, r101);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        storeInIconCache(r102, r104);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r104;
    L16:
        Drawable r105 = checkIconCache(r100);
        if (r105 == null) goto L19;
        return r105;
    L19:
        Drawable r106 = getDrawable(UriProtector.parse(r100));
        storeInIconCache(r100, r106);
        return r106;
    L15:
        return null;
    }

    private Drawable getIcon1(Cursor r100) {
        int r101 = this.mIconName1Col;
        if (r101 != (-1)) goto L6;
        return null;
    L6:
        Drawable r102 = getDrawableFromResourceValue(r100.getString(r101));
        if (r102 == null) goto L10;
        return r102;
    L10:
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor r100) {
        int r101 = this.mIconName2Col;
        if (r101 != (-1)) goto L7;
        return null;
    L7:
        return getDrawableFromResourceValue(r100.getString(r101));
    }

    private void updateSpinnerState(Cursor r100) {
        if (r100 == null) goto L4;
        Bundle r101 = r100.getExtras();
    L5:
        if (r101 == null) goto L8;
        r101.getBoolean("in_progress");
        return;
    L8:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r100) {
        if (this.mClosed == false) goto L12;
        if (r100 == null) goto L14;
        r100.close();
        return;
    L14:
        return;
    L12:
        super.changeCursor(r100);     // Catch: Exception -> L11
        if (r100 == null) goto L15;
        this.mText1Col = r100.getColumnIndex("suggest_text_1");     // Catch: Exception -> L11
        this.mText2Col = r100.getColumnIndex("suggest_text_2");     // Catch: Exception -> L11
        this.mText2UrlCol = r100.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L11
        this.mIconName1Col = r100.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L11
        this.mIconName2Col = r100.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L11
        this.mFlagsCol = r100.getColumnIndex("suggest_flags");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = getColumnString(r100, "suggest_intent_query");
        if (r101 == null) goto L9;
        return r101;
    L9:
        if (this.mSearchable.shouldRewriteQueryFromData() == false) goto L14;
        String r102 = getColumnString(r100, "suggest_intent_data");
        if (r102 == null) goto L14;
        return r102;
    L14:
        if (this.mSearchable.shouldRewriteQueryFromText() == false) goto L18;
        String r103 = getColumnString(r100, "suggest_text_1");
        if (r103 == null) goto L18;
        return r103;
    L18:
        return null;
    }

    public Drawable getDrawableFromResourceUri(Uri r100) throws FileNotFoundException {
        String r101 = r100.getAuthority();
        if (TextUtils.isEmpty(r101) == true) goto L28;
        Resources r102 = this.mProviderContext.getPackageManager().getResourcesForApplication(r101);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r103 = r100.getPathSegments();
        if (r103 == null) goto L24;
        int r104 = r103.size();
        if (r104 != 1) goto L14;
        int r105 = CastIntegerProtector.parseInt((String) ListProtector.get(r103, 0));     // Catch: NumberFormatException -> L11
    L16:
        if (r105 == 0) goto L20;
        return r102.getDrawable(r105);
    L20:
        throw new FileNotFoundException("No resource found for: " + r100);
    L12:
        throw new FileNotFoundException("Single path segment is not a resource ID: " + r100);
    L14:
        if (r104 != 2) goto L22;
        r105 = r102.getIdentifier((String) ListProtector.get(r103, 1), (String) ListProtector.get(r103, 0), r101);
        goto L16
    L22:
        throw new FileNotFoundException("More than two path segments: " + r100);
    L24:
        throw new FileNotFoundException("No path: " + r100);
    L26:
        throw new FileNotFoundException("No package found for authority: " + r100);
    L28:
        throw new FileNotFoundException("No authority: " + r100);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        Object r101 = r100.getTag();
        if ((r101 instanceof CharSequence) == false) goto L6;
        this.mSearchView.onQueryRefine((CharSequence) r101);
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r100) {
        if (r100 != null) goto L4;
        String r101 = "";
    L6:
        if (this.mSearchView.getVisibility() == 0) goto L8;
    L14:
        return null;
    L8:
        if (this.mSearchView.getWindowVisibility() != 0) goto L14;
        Cursor r102 = getSearchManagerSuggestions(this.mSearchable, r101, 50);     // Catch: RuntimeException -> L15
        if (r102 == null) goto L14;
        r102.getCount();     // Catch: RuntimeException -> L15
        return r102;
    L4:
        r101 = r100.toString();
        goto L6
    }

    public void setQueryRefinement(int r100) {
        this.mQueryRefinement = r100;
    }

    public static String getColumnString(Cursor r100, String r101) {
        return getStringOrNull(r100, r100.getColumnIndex(r101));
    }

    private static String getStringOrNull(Cursor r100, int r101) {
        if (r101 != (-1)) goto L8;
        return null;
    L8:
        return r100.getString(r101);
    L7:
        return null;
    }

    private void setViewText(TextView r100, CharSequence r101) {
        r100.setText(r101);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r100.setVisibility(8);
        return;
    L5:
        r100.setVisibility(0);
    }

    private void storeInIconCache(String r100, Drawable r101) {
        if (r101 == null) goto L5;
        this.mOutsideDrawablesCache.put(r100, r101.getConstantState());
        return;
    }

    private void setViewDrawable(ImageView r100, Drawable r101, int r102) {
        r100.setImageDrawable(r101);
        if (r101 != null) goto L5;
        r100.setVisibility(r102);
        return;
    L5:
        r100.setVisibility(0);
        r101.setVisible(false, false);
        r101.setVisible(true, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r100, Context r101, Cursor r102) {
        ChildViewCache r103 = (ChildViewCache) r100.getTag();
        int r104 = this.mFlagsCol;
        if (r104 == (-1)) goto L5;
        int r105 = r102.getInt(r104);
    L7:
        if (r103.mText1 == null) goto L10;
        String r106 = getStringOrNull(r102, this.mText1Col);
        setViewText(r103.mText1, r106);
    L10:
        if (r103.mText2 == null) goto L24;
        String r107 = getStringOrNull(r102, this.mText2UrlCol);
        if (r107 == null) goto L14;
        CharSequence r108 = formatUrl(r107);
    L16:
        if (TextUtils.isEmpty(r108) == false) goto L20;
        TextView r109 = r103.mText1;
        if (r109 == null) goto L23;
        r109.setSingleLine(false);
        r103.mText1.setMaxLines(2);
    L23:
        setViewText(r103.mText2, r108);
        goto L24
    L20:
        TextView r110 = r103.mText1;
        if (r110 == null) goto L23;
        r110.setSingleLine(true);
        r103.mText1.setMaxLines(1);
        goto L23
    L14:
        r108 = getStringOrNull(r102, this.mText2Col);
    L24:
        ImageView r111 = r103.mIcon1;
        if (r111 == null) goto L27;
        setViewDrawable(r111, getIcon1(r102), 4);
    L27:
        ImageView r112 = r103.mIcon2;
        if (r112 == null) goto L30;
        setViewDrawable(r112, getIcon2(r102), 8);
    L30:
        int r113 = this.mQueryRefinement;
        if (r113 == 2) goto L37;
        if (r113 == 1) goto L34;
    L36:
        r103.mIconRefine.setVisibility(8);
        return;
    L34:
        if ((r105 & 1) == 0) goto L36;
    L37:
        r103.mIconRefine.setVisibility(0);
        r103.mIconRefine.setTag(r103.mText1.getText());
        r103.mIconRefine.setOnClickListener(this);
        return;
    L5:
        r105 = 0;
        goto L7
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r100, View r101, ViewGroup r102) {
        return super.getDropDownView(r100, r101, r102);
    L4:
        e = move-exception;
        View r103 = newDropDownView(this.mProviderContext, getCursor(), r102);
        if (r103 == null) goto L8;
        ((ChildViewCache) r103.getTag()).mText1.setText(e.toString());
    L8:
        return r103;
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo r110, String r111, int r112) {
        String[] r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        String r101 = r110.getSuggestAuthority();
        if (r101 != null) goto L8;
        return null;
    L8:
        Uri.Builder r102 = new Uri.Builder().scheme("content").authority(r101).query("").fragment("");
        String r103 = r110.getSuggestPath();
        if (r103 == null) goto L11;
        r102.appendEncodedPath(r103);
    L11:
        r102.appendPath("search_suggest_query");
        String r104 = r110.getSuggestSelection();
        if (r104 == null) goto L14;
        r100 = new String[]{r111};
    L15:
        String[] r105 = r100;
        if (r112 <= 0) goto L19;
        r102.appendQueryParameter(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, String.valueOf(r112));
    L19:
        return androidx_appcompat_widget_SuggestionsAdapter_android_content_ContentResolver_query(this.mProviderContext.getContentResolver(), r102.build(), null, r104, r105, null);
    L14:
        r102.appendPath(r111);
        goto L15
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r100, View r101, ViewGroup r102) {
        return super.getView(r100, r101, r102);
    L4:
        e = move-exception;
        View r103 = newView(this.mProviderContext, getCursor(), r102);
        if (r103 == null) goto L8;
        ((ChildViewCache) r103.getTag()).mText1.setText(e.toString());
    L8:
        return r103;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r100, Cursor r101, ViewGroup r102) {
        View r103 = super.newView(r100, r101, r102);
        r103.setTag(new ChildViewCache(r103));
        ((ImageView) r103.findViewById(com.larus.nova.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return r103;
    }

    public SuggestionsAdapter(Context r100, SearchView r101, SearchableInfo r102, WeakHashMap<String, Drawable.ConstantState> r103) {
        super(r100, r101.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = r101;
        this.mSearchable = r102;
        this.mCommitIconResId = r101.getSuggestionCommitIconResId();
        this.mProviderContext = r100;
        this.mOutsideDrawablesCache = r103;
    }

    private static Cursor androidx_appcompat_widget_SuggestionsAdapter_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
