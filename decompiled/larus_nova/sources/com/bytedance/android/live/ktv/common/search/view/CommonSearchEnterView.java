package com.bytedance.android.live.ktv.common.search.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.SpannableStringUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.model.api.t;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvPullLoadingAnimView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u001cR\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0018R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b4\u00101R\u001d\u00109\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010G¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "searchResultView", "", "setSearchResultView", "Lcom/bytedance/android/live/ktv/common/search/view/q;", "outerCallback", "setOuterCallback", "Lkotlin/Function0;", "cancelAction", "setCancelAction", "", "getSearchStartTime", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", "getTvCancel", "()Landroid/widget/TextView;", "tvCancel", "Landroidx/constraintlayout/widget/ConstraintLayout;", ce.f26391f, "getSearchBar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "searchBar", "h", "getBtnKtvSearch", "()Landroid/view/View;", "btnKtvSearch", "Landroid/widget/EditText;", RXScreenCaptureService.KEY_INDEX, "getEtSearch", "()Landroid/widget/EditText;", "etSearch", ce.f26395j, "getBtnClear", "btnClear", "Landroidx/recyclerview/widget/RecyclerView;", ce.f26396k, "getSearchGuessWord", "()Landroidx/recyclerview/widget/RecyclerView;", "searchGuessWord", "l", "getHistoryHotWord", "historyHotWord", "Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "m", "getSearchHistory", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "searchHistory", OfficeSDKRequestTag.KEY_NEW_USER, "getHotWord", "hotWord", "o", "getSearchLoadingContainer", "()Landroid/widget/FrameLayout;", "searchLoadingContainer", "Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "p", "getSearchLoadingAnim", "()Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "searchLoadingAnim", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "r", "getCommonSearchGuessWordAdapter", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "commonSearchGuessWordAdapter", "Landroid/text/TextWatcher;", "s", "getTextWatch", "()Landroid/text/TextWatcher;", "textWatch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchEnterView extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f70261v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f70262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f70265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f70266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f70267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f70268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f70269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f70270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f70271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f70272k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f70273l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f70274m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f70275n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f70276o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f70277p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.search.viewmodel.a f70278q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f70279r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f70280s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Function0<Unit> f70281t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f70282u;

    public static final class a {
    }

    static {
    }

    public CommonSearchEnterView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonSearchEnterView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getBtnClear() {
        return (View) this.f70271j.getValue();
    }

    private final View getBtnKtvSearch() {
        return (View) this.f70269h.getValue();
    }

    private final CommonSearchGuessWordAdapter getCommonSearchGuessWordAdapter() {
        return (CommonSearchGuessWordAdapter) this.f70279r.getValue();
    }

    private final EditText getEtSearch() {
        return (EditText) this.f70270i.getValue();
    }

    private final ConstraintLayout getHistoryHotWord() {
        return (ConstraintLayout) this.f70273l.getValue();
    }

    private final CommonHotWordHistoryView getHotWord() {
        return (CommonHotWordHistoryView) this.f70275n.getValue();
    }

    private final ConstraintLayout getSearchBar() {
        return (ConstraintLayout) this.f70268g.getValue();
    }

    private final RecyclerView getSearchGuessWord() {
        return (RecyclerView) this.f70272k.getValue();
    }

    private final CommonHotWordHistoryView getSearchHistory() {
        return (CommonHotWordHistoryView) this.f70274m.getValue();
    }

    private final KtvPullLoadingAnimView getSearchLoadingAnim() {
        return (KtvPullLoadingAnimView) this.f70277p.getValue();
    }

    private final FrameLayout getSearchLoadingContainer() {
        return (FrameLayout) this.f70276o.getValue();
    }

    private final TextWatcher getTextWatch() {
        return (TextWatcher) this.f70280s.getValue();
    }

    private final TextView getTvCancel() {
        return (TextView) this.f70267f.getValue();
    }

    public final void g() {
        if (this.f70264c == 4) goto L5;
        i(4);
    L5:
        EditText r100 = getEtSearch();
        if (r100 == null) goto L10;
        CharSequence r101 = r100.getHint();
        if (r101 == null) goto L10;
        String r102 = r101.toString();
    L12:
        if ((!Intrinsics.areEqual(r102, this.f70263b)) == false) goto L16;
        EditText r103 = getEtSearch();
        if (r103 == null) goto L16;
        r103.setHint(this.f70263b);
    L16:
        e();
        return;
    L10:
        r102 = null;
        goto L12
    }

    public final void e() {
        Activity r100 = ContextUtil.contextToActivity(getContext());
        IBinder r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getSystemService("input_method");
    L7:
        if ((r102 instanceof InputMethodManager) == false) goto L18;
        EditText r103 = getEtSearch();
        if (r103 == null) goto L11;
        IBinder r104 = r103.getWindowToken();
    L12:
        if (r104 == null) goto L19;
        InputMethodManager r105 = (InputMethodManager) r102;
        EditText r106 = getEtSearch();
        if (r106 == null) goto L16;
        r101 = r106.getWindowToken();
    L16:
        r105.hideSoftInputFromWindow(r101, 0);
        return;
    L19:
        return;
    L11:
        r104 = null;
        goto L12
    L18:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void f() {
        EditText r100 = getEtSearch();
        if (r100 == null) goto L5;
        r100.requestFocus();
    L5:
        Activity r101 = ContextUtil.contextToActivity(getContext());
        if (r101 == null) goto L8;
        Object r102 = r101.getSystemService("input_method");
    L10:
        if ((r102 instanceof InputMethodManager) == false) goto L15;
        EditText r103 = getEtSearch();
        if (r103 == null) goto L16;
        ((InputMethodManager) r102).showSoftInput(r103, 0);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r102 = null;
        goto L10
    }

    public long getSearchStartTime() {
        return this.f70265d;
    }

    public static final /* synthetic */ View a(CommonSearchEnterView r100) {
        return r100.getBtnClear();
    }

    public static final /* synthetic */ EditText b(CommonSearchEnterView r100) {
        return r100.getEtSearch();
    }

    public final void d(String r100) {
        EditText r101 = getEtSearch();
        if (r101 == null) goto L8;
        if (r100 != null) goto L7;
        r100 = this.f70263b;
    L7:
        r101.setHint(r100);
    L8:
        EditText r102 = getEtSearch();
        if (r102 == null) goto L11;
        r102.setCursorVisible(true);
    L11:
        i(1);
        if (this.f70264c == 1) goto L14;
        i(1);
    L14:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r103 = this.f70278q;
        if (r103 == null) goto L17;
        r103.syncHotWords();
    L17:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r104 = this.f70278q;
        if (r104 == null) goto L20;
        r104.loadSearchHistory();
    L20:
        f();
        TextView r105 = getTvCancel();
        if (r105 == null) goto L24;
        r105.setVisibility(0);
        return;
    }

    public final void i(int r100) {
        int r101 = this.f70264c;
        if (r101 != 4) goto L8;
        if (r100 == r101) goto L8;
        q r102 = this.f70262a;
        if (r102 == null) goto L8;
        r102.onSearchReset();
    L8:
        boolean r103 = true;
        if (r100 != 1) goto L13;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r104 = this.f70278q;
        if (r104 == null) goto L13;
        r104.loadSearchHistory();
    L13:
        this.f70264c = r100;
        RecyclerView r105 = getSearchGuessWord();
        if (r105 != null) goto L16;
    L20:
        ConstraintLayout r106 = getHistoryHotWord();
        if (r106 == null) goto L26;
        if (r100 != 1) goto L24;
        int r107 = 0;
    L25:
        r106.setVisibility(r107);
        goto L26
    L24:
        r107 = 8;
    L26:
        View r108 = this.f70266e;
        if (r108 == null) goto L33;
        if (r100 != 4) goto L30;
        int r109 = 0;
    L31:
        r108.setVisibility(r109);
        goto L33
    L30:
        r109 = 8;
    L33:
        if (r100 == 3) goto L36;
        r103 = false;
    L36:
        if (r103 == false) goto L46;
        FrameLayout r110 = getSearchLoadingContainer();
        if (r110 == null) goto L40;
        r110.setVisibility(0);
    L40:
        KtvPullLoadingAnimView r111 = getSearchLoadingAnim();
        if (r111 == null) goto L43;
        r111.setVisibility(0);
    L43:
        KtvPullLoadingAnimView r112 = getSearchLoadingAnim();
        if (r112 == null) goto L56;
        r112.R5();
        return;
    L56:
        return;
    L46:
        KtvPullLoadingAnimView r113 = getSearchLoadingAnim();
        if (r113 == null) goto L49;
        r113.setVisibility(8);
    L49:
        KtvPullLoadingAnimView r114 = getSearchLoadingAnim();
        if (r114 == null) goto L52;
        r114.S5();
    L52:
        FrameLayout r115 = getSearchLoadingContainer();
        if (r115 == null) goto L58;
        r115.setVisibility(8);
        return;
    L58:
        return;
    L16:
        if (r100 != 2) goto L18;
        int r116 = 0;
    L19:
        r105.setVisibility(r116);
        goto L20
    L18:
        r116 = 8;
        goto L19
    }

    public final void j(List<s> r110) {
        if (ListUtils.isEmpty(r110) == true) goto L5;
    L7:
        int r100 = this.f70264c;
        if (r100 == 3) goto L11;
        if (r100 == 4) goto L11;
        i(2);
    L11:
        RecyclerView r101 = getSearchGuessWord();
        if (r101 == null) goto L14;
        r101.setAdapter(getCommonSearchGuessWordAdapter());
    L14:
        if (r110 == null) goto L34;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r110.iterator();
    L17:
        if (r103.hasNext() == false) goto L25;
        s r104 = (s) r103.next();
        ArrayList r105 = new ArrayList();
        List<t> r106 = r104.d();
        if (r106 == null) goto L24;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        t r108 = (t) r107.next();
        r105.add(new Pair(Integer.valueOf((int) r108.a()), Integer.valueOf(((int) r108.b()) + 1)));
    L24:
        r102.add(SpannableStringUtils.getDiffColorSpannable(r104.b(), r104.a(), r105));
        goto L17
    L25:
        CommonSearchGuessWordAdapter r109 = getCommonSearchGuessWordAdapter();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r102, "wordList");
        Intrinsics.checkNotNullParameter(r110, "guessList");
        ((ArrayList) r109.f70284a).clear();
        ((ArrayList) r109.f70284a).addAll(r102);
        ((ArrayList) r109.f70285b).clear();
        ArrayList r111 = (ArrayList) r109.f70285b;
        r111.addAll(r110);
        RecyclerView r112 = getSearchGuessWord();
        if (r112 == null) goto L28;
        r112.setLayoutManager(new LinearLayoutManager(getContext()));
    L28:
        getCommonSearchGuessWordAdapter().notifyDataSetChanged();
        return;
    L34:
        return;
    L5:
        if (this.f70264c == 4) goto L7;
        i(1);
    }

    public final void k(List<String> r100) {
        if (r100 == null) goto L7;
        List<String> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L8;
        r102.add(new u((String) r103.next()));
    L8:
        CommonHotWordHistoryView r104 = getSearchHistory();
        if (r104 == null) goto L13;
        r104.b(0, r102);
        return;
    L13:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void l(List<u> r100) {
        CommonHotWordHistoryView r101 = getHotWord();
        if (r101 == null) goto L6;
        r101.b(1, r100);
        return;
    }

    public void setCancelAction(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cancelAction");
        this.f70281t = r100;
    }

    public void setOuterCallback(q r100) {
        Intrinsics.checkNotNullParameter(r100, "outerCallback");
        this.f70262a = r100;
        this.f70278q = r100.e();
    }

    public void setSearchResultView(View r100) {
        this.f70266e = r100;
    }

    public static final boolean c(CommonSearchEnterView r100, int r101) {
        if (r101 != 3) goto L31;
        EditText r102 = r100.getEtSearch();
        String r103 = null;
        if (r102 == null) goto L23;
        Editable r104 = r102.getText();
        if (r104 == null) goto L23;
        if (StringsKt.isBlank(r104) != true) goto L23;
        EditText r105 = r100.getEtSearch();
        if (r105 == null) goto L15;
        CharSequence r106 = r105.getHint();
        if (r106 == null) goto L15;
        String r107 = r106.toString();
    L17:
        if ((!Intrinsics.areEqual(r107, r100.f70263b)) == false) goto L23;
        EditText r108 = r100.getEtSearch();
        if (r108 == null) goto L28;
        CharSequence r109 = r108.getHint();
        if (r109 == null) goto L28;
        r103 = r109.toString();
    L28:
        if (r103 != null) goto L30;
        r103 = "";
    L30:
        r100.h(r103, "ugc", false);
        return true;
    L15:
        r107 = null;
    L23:
        EditText r110 = r100.getEtSearch();
        if (r110 == null) goto L28;
        Editable r111 = r110.getText();
        if (r111 == null) goto L28;
        r103 = r111.toString();
        goto L28
    L31:
        r100.getClass();
        return false;
    }

    public CommonSearchEnterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f70263b = s1.B(R.string.ttlive_ktv_search_hint);
        this.f70264c = 1;
        this.f70267f = LazyKt.lazy(new CommonSearchEnterView$tvCancel$2(this));
        this.f70268g = LazyKt.lazy(new CommonSearchEnterView$searchBar$2(this));
        this.f70269h = LazyKt.lazy(new CommonSearchEnterView$btnKtvSearch$2(this));
        this.f70270i = LazyKt.lazy(new CommonSearchEnterView$etSearch$2(this));
        this.f70271j = LazyKt.lazy(new CommonSearchEnterView$btnClear$2(this));
        this.f70272k = LazyKt.lazy(new CommonSearchEnterView$searchGuessWord$2(this));
        this.f70273l = LazyKt.lazy(new CommonSearchEnterView$historyHotWord$2(this));
        this.f70274m = LazyKt.lazy(new CommonSearchEnterView$searchHistory$2(this));
        this.f70275n = LazyKt.lazy(new CommonSearchEnterView$hotWord$2(this));
        this.f70276o = LazyKt.lazy(new CommonSearchEnterView$searchLoadingContainer$2(this));
        this.f70277p = LazyKt.lazy(new CommonSearchEnterView$searchLoadingAnim$2(this));
        this.f70279r = LazyKt.lazy(new CommonSearchEnterView$commonSearchGuessWordAdapter$2(this));
        this.f70280s = LazyKt.lazy(new CommonSearchEnterView$textWatch$2(this));
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.search_enter_enable_font_scale});
        boolean r104 = r103.getBoolean(0, false);
        this.f70282u = r104;
        r103.recycle();
        if (r104 == false) goto L5;
        int r105 = R.layout.ttlive_ktv_common_search_enter_adapt_view;
    L6:
        LayoutInflater.from(r100).inflate(r105, this);
        View r106 = getBtnKtvSearch();
        if (r106 == null) goto L9;
        r106.setOnClickListener(new l(this));
    L9:
        EditText r107 = getEtSearch();
        if (r107 == null) goto L12;
        r107.setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70201j));
    L12:
        EditText r108 = getEtSearch();
        if (r108 == null) goto L15;
        r108.setTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70201j));
    L15:
        View r109 = getBtnKtvSearch();
        if (r109 == null) goto L18;
        KtvOrderSongThemeManager.c(r109, KtvOrderSongThemeManager.f70200i);
    L18:
        View r110 = getBtnClear();
        if (r110 == null) goto L21;
        KtvOrderSongThemeManager.c(r110, KtvOrderSongThemeManager.f70204m);
    L21:
        View r111 = getBtnClear();
        if (r111 == null) goto L24;
        r111.setOnClickListener(new m(this));
    L24:
        TextView r112 = getTvCancel();
        if (r112 == null) goto L27;
        r112.setOnClickListener(new n(this));
    L27:
        EditText r113 = getEtSearch();
        if (r113 == null) goto L30;
        r113.setOnTouchListener(new o(this));
    L30:
        EditText r114 = getEtSearch();
        if (r114 == null) goto L33;
        r114.addTextChangedListener(getTextWatch());
    L33:
        EditText r115 = getEtSearch();
        if (r115 == null) goto L36;
        r115.setOnEditorActionListener(new p(this));
    L36:
        ConstraintLayout r116 = getSearchBar();
        if (r116 == null) goto L39;
        KtvOrderSongThemeManager.c(r116, KtvOrderSongThemeManager.f70199h);
    L39:
        EditText r117 = getEtSearch();
        if (r117 == null) goto L42;
        r117.setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70192a));
    L42:
        CommonHotWordHistoryView r118 = getSearchHistory();
        if (r118 == null) goto L45;
        r118.setHistoryRemoveAction(new CommonSearchEnterView$initHistoryAndHotWordView$1(this));
    L45:
        CommonHotWordHistoryView r119 = getSearchHistory();
        if (r119 == null) goto L48;
        r119.setHotWordHistoryClickAction(new CommonSearchEnterView$initHistoryAndHotWordView$2(this));
    L48:
        CommonHotWordHistoryView r120 = getHotWord();
        if (r120 == null) goto L51;
        r120.setHotWordHistoryClickAction(new CommonSearchEnterView$initHistoryAndHotWordView$3(this));
    L51:
        i(1);
        CommonHotWordHistoryView r121 = getSearchHistory();
        if (r121 == null) goto L54;
        r121.setVisibility(8);
    L54:
        TextView r122 = getTvCancel();
        if (r122 == null) goto L58;
        KtvOrderSongThemeManager.d(r122, KtvOrderSongThemeManager.f70197f);
        return;
    L58:
        return;
    L5:
        r105 = R.layout.ttlive_ktv_common_search_enter_view;
        goto L6
    }

    public final void h(String r100, String r101, boolean r102) {
        ALogger.i("CommonSearchEnterView", "trySearch");
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        return;
    L8:
        if (StringsKt.trim(r100).toString().length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L32;
        this.f70265d = System.currentTimeMillis();
        e();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r105 = this.f70278q;
        if (r105 == null) goto L15;
        r105.doSearch(r100, true, r101, r102);
    L15:
        i(3);
        EditText r106 = getEtSearch();
        if (r106 == null) goto L18;
        r106.setCursorVisible(false);
    L18:
        EditText r107 = getEtSearch();
        if (r107 == null) goto L21;
        r107.removeTextChangedListener(getTextWatch());
    L21:
        EditText r108 = getEtSearch();
        if (r108 == null) goto L24;
        r108.addTextChangedListener(getTextWatch());
    L24:
        EditText r109 = getEtSearch();
        if (r109 == null) goto L27;
        r109.setText(r100);
    L27:
        EditText r110 = getEtSearch();
        if (r110 == null) goto L33;
        r110.setSelection(r100.length());
        return;
    L33:
        return;
    L32:
        return;
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ CommonSearchEnterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
