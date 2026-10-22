package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.LruCache;
import com.bytedance.android.ec.core.rxjava.ECCompletableMergeArray;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.components.LongTitleComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/InlineLongTitleComponentView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getResizeBitmap", "()Z", "setResizeBitmap", "(Z)V", "resizeBitmap", "b", "getResizeToLineHeight", "setResizeToLineHeight", "resizeToLineHeight", "", "c", FaceService.girlLabel, "getLineSpace", "()F", "setLineSpace", "(F)V", "lineSpace", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InlineLongTitleComponentView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, h> f167943d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<String, h> f167944e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f167945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f167947c;

    public static final class a {
    }

    static {
        f167943d = new LruCache(10);
        f167944e = new LruCache(5);
    }

    public final float getLineSpace() {
        return this.f167947c;
    }

    public final boolean getResizeBitmap() {
        return this.f167945a;
    }

    public final boolean getResizeToLineHeight() {
        return this.f167946b;
    }

    public InlineLongTitleComponentView(Context r100) {
        this(r100, null);
    }

    public final void setLineSpace(float r100) {
        this.f167947c = r100;
    }

    public final void setResizeBitmap(boolean r100) {
        this.f167945a = r100;
    }

    public final void setResizeToLineHeight(boolean r100) {
        this.f167946b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.widget.TextView, com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.InlineLongTitleComponentView] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    public final void x(LongTitleComponent r110) {
        setLineSpacing(this.f167947c, 1.0f);
        ArrayList r100 = null;
        if (r110 == null) goto L5;
        IconsWithSpaceElement r101 = r110.getHeadIcons();
    L6:
        if (r110 == null) goto L8;
        IconsWithSpaceElement r102 = r110.getTailIcons();
    L9:
        if (r110 == null) goto L11;
        TextElement r111 = r110.getContent();
    L12:
        if (r101 == null) goto L14;
        List<ImageModel> r103 = r101.getIconList();
    L15:
        List<ImageModel> r104 = r103;
        if (r104 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L36;
        if (r102 == null) goto L25;
        List<ImageModel> r106 = r102.getIconList();
    L26:
        List<ImageModel> r107 = r106;
        if (r107 != null) goto L29;
    L32:
        boolean r108 = true;
    L33:
        if (r108 == false) goto L36;
        z(CollectionsKt.emptyList(), 0, CollectionsKt.emptyList(), 0, r111, this);
        return;
    L29:
        if (r107.isEmpty() == true) goto L32;
        r108 = false;
        goto L33
    L25:
        r106 = null;
    L36:
        if (r101 == null) goto L49;
        List<ImageModel> r109 = r101.getIconList();
        if (r109 == null) goto L49;
        List<ImageModel> r112 = r109;
        ?? r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L41:
        if (r114.hasNext() == false) goto L50;
        ECUrlModel r115 = ((ImageModel) r114.next()).getRemote();
        if (r115 == null) goto L45;
        String r116 = r115.getUri();
    L46:
        if (r116 != null) goto L48;
        r116 = "";
    L48:
        r113.add(r116);
        goto L41
    L45:
        r116 = null;
    L50:
        List r117 = y(true, r113);
        if (r102 == null) goto L64;
        List<ImageModel> r118 = r102.getIconList();
        if (r118 == null) goto L64;
        List<ImageModel> r119 = r118;
        ?? r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L56:
        if (r121.hasNext() == false) goto L65;
        ECUrlModel r122 = ((ImageModel) r121.next()).getRemote();
        if (r122 == null) goto L60;
        String r123 = r122.getUri();
    L61:
        if (r123 != null) goto L63;
        r123 = "";
    L63:
        r120.add(r123);
        goto L56
    L60:
        r123 = null;
    L65:
        List r124 = y(false, r120);
        int r125 = ((ArrayList) r117).size();
        if (r101 == null) goto L70;
        List<ImageModel> r126 = r101.getIconList();
        if (r126 == null) goto L70;
        int r127 = r126.size();
    L71:
        if (r125 != r127) goto L86;
        int r128 = ((ArrayList) r124).size();
        if (r102 == null) goto L77;
        List<ImageModel> r129 = r102.getIconList();
        if (r129 == null) goto L77;
        int r130 = r129.size();
    L78:
        if (r128 != r130) goto L86;
        if (r101 == null) goto L81;
        int r131 = r101.getSpace();
    L82:
        if (r102 == null) goto L84;
        int r132 = r102.getSpace();
    L85:
        z(r117, r131, r124, r132, r111, this);
        return;
    L84:
        r132 = 0;
        goto L85
    L81:
        r131 = 0;
    L77:
        r130 = 0;
    L86:
        if (r101 == null) goto L102;
        List<ImageModel> r133 = r101.getIconList();
        if (r133 == null) goto L102;
        ArrayList r134 = new ArrayList();
        Iterator r135 = r133.iterator();
    L91:
        if (r135.hasNext() == false) goto L98;
        Object r136 = r135.next();
        if (((ImageModel) r136).getRemote() == null) goto L95;
        boolean r137 = true;
    L96:
        if (r137 == false) goto L91;
        r134.add(r136);
        goto L91
    L95:
        r137 = false;
        goto L96
    L98:
        ?? r138 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r139 = r134.iterator();
    L100:
        if (r139.hasNext() == false) goto L103;
        ImageModel r140 = (ImageModel) r139.next();
        ECUrlModel r141 = r140.getRemote();
        Intrinsics.checkNotNull(r141);
        r138.add(new h(null, r141.getWidth(), r140.getRemote().getHeight()));
    L103:
        ?? r142 = r138;
        if (r101 == null) goto L106;
        int r143 = r101.getSpace();
    L107:
        if (r102 == null) goto L123;
        List<ImageModel> r144 = r102.getIconList();
        if (r144 == null) goto L123;
        ArrayList r145 = new ArrayList();
        Iterator r146 = r144.iterator();
    L112:
        if (r146.hasNext() == false) goto L119;
        Object r147 = r146.next();
        if (((ImageModel) r147).getRemote() == null) goto L116;
        boolean r148 = true;
    L117:
        if (r148 == false) goto L112;
        r145.add(r147);
        goto L112
    L116:
        r148 = false;
        goto L117
    L119:
        ?? r149 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r145, 10));
        Iterator r150 = r145.iterator();
    L121:
        if (r150.hasNext() == false) goto L124;
        ImageModel r151 = (ImageModel) r150.next();
        ECUrlModel r152 = r151.getRemote();
        Intrinsics.checkNotNull(r152);
        r149.add(new h(null, r152.getWidth(), r151.getRemote().getHeight()));
    L124:
        ?? r153 = r149;
        if (r102 == null) goto L127;
        int r154 = r102.getSpace();
    L128:
        z(r142, r143, r153, r154, r111, this);
        ArrayList r155 = new ArrayList();
        u r156 = u.f167989a;
        if (r101 == null) goto L152;
        List<ImageModel> r157 = r101.getIconList();
        if (r157 == null) goto L152;
        ArrayList r158 = new ArrayList();
        Iterator r159 = r157.iterator();
    L134:
        if (r159.hasNext() == false) goto L138;
        ECUrlModel r160 = ((ImageModel) r159.next()).getRemote();
        if (r160 == null) goto L134;
        r158.add(r160);
        goto L134
    L138:
        ArrayList r161 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r158, 10));
        Iterator r162 = r158.iterator();
        int r163 = 0;
    L140:
        if (r162.hasNext() == false) goto L146;
        Object r164 = r162.next();
        int r165 = r163 + 1;
        if (r163 >= 0) goto L144;
        CollectionsKt.throwIndexOverflow();
    L144:
        r161.add(Observable.create(new t((ECUrlModel) r164, r163)).onErrorReturn(r156));
        r163 = r165;
        goto L140
    L146:
        if ((!r161.isEmpty()) == true) goto L149;
        r161 = null;
    L149:
        if (r161 == null) goto L152;
        Observable r166 = Observable.zip(r161, new o(r155));
        if (r166 == null) goto L152;
    L153:
        ArrayList r167 = new ArrayList();
        if (r102 == null) goto L176;
        List<ImageModel> r168 = r102.getIconList();
        if (r168 == null) goto L176;
        ArrayList r169 = new ArrayList();
        Iterator r170 = r168.iterator();
    L159:
        if (r170.hasNext() == false) goto L163;
        ECUrlModel r171 = ((ImageModel) r170.next()).getRemote();
        if (r171 == null) goto L159;
        r169.add(r171);
        goto L159
    L163:
        ArrayList r172 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r169, 10));
        Iterator r173 = r169.iterator();
        int r174 = 0;
    L165:
        if (r173.hasNext() == false) goto L171;
        Object r175 = r173.next();
        int r176 = r174 + 1;
        if (r174 >= 0) goto L169;
        CollectionsKt.throwIndexOverflow();
    L169:
        r172.add(Observable.create(new t((ECUrlModel) r175, r174)).onErrorReturn(r156));
        r174 = r176;
        goto L165
    L171:
        if ((!r172.isEmpty()) == false) goto L173;
        r100 = r172;
    L173:
        if (r100 == null) goto L176;
        Observable r177 = Observable.zip(r100, new q(r167));
        if (r177 == null) goto L176;
    L177:
        CompletableSource[] r178 = {r166.ignoreElements(), r177.ignoreElements()};
        ObjectHelper.requireNonNull(r178, "sources is null");
        fa3.c.b(bg4.b.a(RxJavaPlugins.onAssembly(new ECCompletableMergeArray(r178))).subscribe(new r(this, r155, r101, r167, r111, this), new s(this, r111)));
        return;
    L176:
        r177 = Observable.empty();
    L152:
        r166 = Observable.empty();
        goto L153
    L127:
        r154 = 0;
    L123:
        r149 = CollectionsKt.emptyList();
        goto L124
    L106:
        r143 = 0;
    L102:
        r138 = CollectionsKt.emptyList();
    L70:
        r127 = 0;
    L64:
        r120 = CollectionsKt.emptyList();
    L49:
        r113 = CollectionsKt.emptyList();
        goto L50
    L18:
        if (r104.isEmpty() == true) goto L21;
        r105 = false;
        goto L22
    L14:
        r103 = null;
        goto L15
    L11:
        r111 = null;
        goto L12
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    public InlineLongTitleComponentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f167945a = true;
        this.f167947c = com.bytedance.android.shopping.extensions.b.b(4);
        setIncludeFontPadding(false);
        setFirstBaselineToTopHeight(0);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public static List y(boolean r100, List r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        String r104 = (String) r103.next();
        if (r100 == false) goto L8;
        h r105 = f167943d.get(r104);
    L9:
        if (r105 == null) goto L12;
        r102.add(r105);
        goto L4
    L12:
        return new ArrayList();
    L8:
        r105 = f167944e.get(r104);
        goto L9
    L13:
        return r102;
    }

    public final void z(List<h> r110, int r111, List<h> r112, int r113, TextElement r210, TextView r211) {
        SpannableStringBuilder r100 = new SpannableStringBuilder();
        Iterator<T> r101 = r110.iterator();
        int r102 = 0;
    L3:
        Integer r103 = null;
        if (r101.hasNext() == false) goto L38;
        Object r104 = r101.next();
        int r114 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        h r105 = (h) r104;
        if (this.f167945a == true) goto L11;
    L29:
        Bitmap r106 = r105.f167961a;
    L30:
        SpannableString r107 = new SpannableString(" ");
        if (r106 == null) goto L33;
        Object r108 = new com.bytedance.android.shopping.widget.c(getContext(), r106);
    L34:
        r107.setSpan(r108, 0, 1, 17);
        r100.append(r107);
        if (r111 <= 0) goto L37;
        SpannableString r109 = new SpannableString(" ");
        r109.setSpan(new com.bytedance.commerce.base.richtext.b.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r111))), 0, 1, 17);
        r100.append(r109);
    L37:
        r102 = r114;
        goto L3
    L33:
        r108 = new m(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105.f167962b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105.f167963c)));
        goto L34
    L11:
        if (r105.f167961a == null) goto L29;
        Integer r115 = Integer.valueOf(getLineHeight());
        if (r115.intValue() > 0) goto L15;
    L17:
        boolean r116 = false;
    L18:
        if (r116 == false) goto L20;
        r103 = r115;
    L20:
        if (r103 == null) goto L22;
        int r117 = r103.intValue();
    L23:
        int r118 = (int) (((r117 * 1.0f) / r105.f167961a.getHeight()) * r105.f167961a.getWidth());
        if (r117 < 0) goto L28;
        if (r118 < 0) goto L28;
        r106 = Bitmap.createScaledBitmap(r105.f167961a, r118, r117, true);
    L28:
        r106 = r105.f167961a;
        goto L30
    L22:
        r117 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105.f167963c));
        goto L23
    L15:
        if (this.f167946b == false) goto L17;
        r116 = true;
        goto L18
    L38:
        if (r210 == null) goto L40;
        r100.append(v.a(r210));
    L40:
        Iterator<T> r119 = r112.iterator();
        int r120 = 0;
    L42:
        if (r119.hasNext() == false) goto L76;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        h r123 = (h) r121;
        if (this.f167945a == true) goto L49;
    L68:
        Bitmap r124 = r123.f167961a;
    L69:
        if (r113 <= 0) goto L71;
        SpannableString r125 = new SpannableString(" ");
        r125.setSpan(new com.bytedance.commerce.base.richtext.b.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r113))), 0, 1, 17);
        r100.append(r125);
    L71:
        SpannableString r126 = new SpannableString(" ");
        if (r124 == null) goto L74;
        Object r127 = new com.bytedance.android.shopping.widget.c(getContext(), r124);
    L75:
        r126.setSpan(r127, 0, 1, 17);
        r100.append(r126);
        r120 = r122;
        goto L42
    L74:
        r127 = new m(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r123.f167962b)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r123.f167963c)));
        goto L75
    L49:
        if (r123.f167961a == null) goto L68;
        Integer r128 = Integer.valueOf(getLineHeight());
        if (r128.intValue() > 0) goto L53;
    L55:
        boolean r129 = false;
    L56:
        if (r129 == true) goto L59;
        r128 = null;
    L59:
        if (r128 == null) goto L61;
        int r130 = r128.intValue();
    L62:
        int r131 = (int) (((r130 * 1.0f) / r123.f167961a.getHeight()) * r123.f167961a.getWidth());
        if (r130 < 0) goto L67;
        if (r131 < 0) goto L67;
        r124 = Bitmap.createScaledBitmap(r123.f167961a, r131, r130, true);
    L67:
        r124 = r123.f167961a;
        goto L69
    L61:
        r130 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r123.f167963c));
        goto L62
    L53:
        if (this.f167946b == false) goto L55;
        r129 = true;
        goto L56
    L76:
        r211.setText(r100);
    }
}
