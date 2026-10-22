package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f141030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<e> f141031c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f141032d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<i> f141033e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f141034f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r f141035g = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f141036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f141037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f141038c;

        public final p getContext() {
            return this.f141038c;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.h
        public final void a(Queue<m> r110) {
            Intrinsics.checkNotNullParameter(r110, "img");
            if (this.f141037b != null) goto L5;
            return;
        L5:
            p r100 = this.f141038c;
            if (r100 != null) goto L8;
        L10:
            SpannableString r101 = this.f141036a.f141012a;
        L11:
            List<com.bytedance.android.livesdk.interactivity.service.textrender.core.b> r102 = this.f141036a.f141013b;
            if (r102.size() == r110.size()) goto L15;
            return;
        L15:
            if (r110.size() <= 0) goto L77;
            m r103 = r110.poll();
            if (r103 == null) goto L15;
            if (r103.f141026b >= r102.size()) goto L15;
            com.bytedance.android.livesdk.interactivity.service.textrender.core.b r104 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r102, r103.f141026b);
            if (r103.f141025a != null) goto L23;
            ITextPieceImage r105 = r104.f141006c.getImageValue();
            if (r105 == null) goto L15;
            if (r105.getEnableTextWhenFailed() != true) goto L15;
            wb2.g r106 = r104.f141011h;
            if (r106 == null) goto L15;
            r101.removeSpan(r106);
            goto L15
        L23:
            x r107 = r.f141030b;
            Iterator r108 = ((HashSet) r.f141031c).iterator();
            boolean r109 = false;
        L24:
            String r111 = null;
            if (r108.hasNext() == false) goto L44;
            List<CharacterStyle> r112 = ((e) r108.next()).a(r104.f141006c, r103.f141025a);
            if (r112 == null) goto L24;
            Iterator<CharacterStyle> r113 = r112.iterator();
        L30:
            if (r113.hasNext() == false) goto L43;
            CharacterStyle r114 = r113.next();
            if ((r114 instanceof com.bytedance.android.livesdk.widget.a) == false) goto L42;
            com.bytedance.android.livesdk.widget.a r115 = (com.bytedance.android.livesdk.widget.a) r114;
            ITextPieceImage r116 = r104.f141006c.getImageValue();
            if (r116 == null) goto L40;
            py.k r117 = r116.getImageModel();
            if (r117 == null) goto L40;
            py.k.b r118 = r117.getImageContent();
            if (r118 == null) goto L40;
            String r119 = r118.getAccessibilityText();
        L41:
            r115.f161402a = r119;
            x r120 = r.f141030b;
            r109 = true;
        L40:
            r119 = null;
        L42:
            r101.setSpan(r114, r104.f141004a, r104.f141005b, 33);
            goto L30
        L43:
            x r121 = r.f141030b;
            goto L24
        L44:
            r101.removeSpan(r104.f141011h);
            if (r109 == true) goto L15;
            ITextPieceImage r122 = r104.f141006c.getImageValue();
            if (r122 == null) goto L50;
            ITextPieceImage.ScaleType r123 = r122.getScaleType();
        L52:
            if (r123 != ITextPieceImage.ScaleType.FIT_TEXT_SIZE) goto L54;
            com.bytedance.android.livesdk.widget.a r124 = new wb2.c(r103.f141025a);
        L62:
            ITextPieceImage r125 = r104.f141006c.getImageValue();
            if (r125 == null) goto L69;
            py.k r126 = r125.getImageModel();
            if (r126 == null) goto L69;
            py.k.b r127 = r126.getImageContent();
            if (r127 == null) goto L69;
            r111 = r127.getAccessibilityText();
        L69:
            r124.f161402a = r111;
            r101.setSpan(r124, r104.f141004a, r104.f141005b, 33);
            goto L15
        L54:
            ITextPieceImage r128 = r104.f141006c.getImageValue();
            if (r128 == null) goto L57;
            ITextPieceImage.ScaleType r129 = r128.getScaleType();
        L59:
            if (r129 != ITextPieceImage.ScaleType.FIT_TEXT_SIZE_CENTER_CANVAS) goto L61;
            r124 = new wb2.b(r103.f141025a);
            goto L62
        L61:
            r124 = new com.bytedance.android.livesdk.widget.a(r103.f141025a);
            goto L62
        L57:
            r129 = null;
            goto L59
        L50:
            r123 = null;
            goto L52
        L77:
            this.f141037b.b(r101);
            return;
        L8:
            if (r100.a() != true) goto L10;
            r101 = new SpannableString(this.f141036a.f141012a);
            goto L11
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.h
        public final void b(py.k r100) {
            g r101 = this.f141037b;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        public b(b0 r100, c r101, p r102) {
            Intrinsics.checkNotNullParameter(r100, "toLoadSpan");
            this.f141036a = r100;
            this.f141037b = r101;
            this.f141038c = r102;
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f141039a;

        public c(q r100) {
            this.f141039a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.g
        public final void a(py.k r100) {
            if (r100 == null) goto L5;
            this.f141039a.a(r100);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.g
        public final void b(SpannableString r100) {
            Intrinsics.checkNotNullParameter(r100, "updated");
            q r101 = this.f141039a;
            q.a r102 = new q.a();
            Unit r103 = Unit.INSTANCE;
            r101.b(r100, r102);
        }
    }

    public r() {
    }

    static {
        f141035g = new r();
        HashSet r100 = new HashSet();
        f141031c = r100;
        r100.add(new xb2.a());
        r100.add(new xb2.b());
        x r101 = new x();
        f141030b = r101;
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.a.f141040b);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.b.f141041b);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.f141043c);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.d.f141045b);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.e.f141046b);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.f.f141048b);
        r101.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.g.f141049b);
        f141032d = new a();
        ArrayList r102 = new ArrayList();
        f141033e = r102;
        r102.add(new ub2.a());
        r102.add(new ub2.b());
        r102.add(new ub2.d());
        r102.add(new ub2.c());
        f141034f = new o();
    }

    public static i b(ITextPieceImage r100) {
        Intrinsics.checkNotNullParameter(r100, "imagePiece");
        Iterator r101 = ((ArrayList) f141033e).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        i r102 = (i) r101.next();
        if (r102.c(r100) == false) goto L4;
        return r102;
    L8:
        LiveTracingMonitor.EventModule r103 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141063a;
        py.k r104 = r100.getImageModel();
        StringBuilder r105 = new StringBuilder("image error, unknown loader, image type is ");
        if (r104 == null) goto L11;
        Integer r106 = r104.getImageType();
    L12:
        r105.append(r106);
        r105.append(", urls is ");
        if (r104 == null) goto L17;
        List<String> r107 = r104.getUrls();
        if (r107 == null) goto L17;
        String r108 = (String) CollectionsKt.firstOrNull(r107);
    L18:
        r105.append(r108);
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b(r105.toString());
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141064b.f141071g++;
        return null;
    L17:
        r108 = null;
        goto L18
    L11:
        r106 = null;
        goto L12
    }

    public static tb2.d a(a5 r100, yb2.a r101) {
        long r102 = System.currentTimeMillis();
        tb2.d r103 = a0.a(r100, r101);
        LiveTracingMonitor.EventModule r104 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141063a;
        long r105 = System.currentTimeMillis() - r102;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a r106 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141064b;
        r106.f141065a++;
        r106.f141066b += r105;
        if (r103.f545242a.isEmpty() == false) goto L5;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b("text decode empty, patternKey is " + r100.getKey());
        r106.f141067c = r106.f141067c + 1;
    L5:
        return r103;
    }

    public final void c(tb2.d r210, p r211, q r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "renderText");
        Intrinsics.checkNotNullParameter(r211, "rendConfig");
        Intrinsics.checkNotNullParameter(r212, "callBack");
        long r110 = System.currentTimeMillis();
        x r111 = f141030b;
        r111.getClass();
        if (r210.f545242a.size() != 0) goto L5;
        b0 r100 = new b0(new SpannableString(""), new ArrayList());
    L54:
        LiveTracingMonitor.EventModule r101 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141063a;
        long r102 = System.currentTimeMillis() - r110;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a r103 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.f141064b;
        r103.f141068d++;
        r103.f141069e += r102;
        if (r100.f141012a.length() != 0) goto L57;
        boolean r104 = true;
    L58:
        if (r104 == false) goto L61;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b("span create empty");
        r103.f141070f++;
    L61:
        if (r100.f141013b.isEmpty() == false) goto L76;
        SpannableString r105 = r100.f141012a;
        q.a r106 = new q.a();
        List<tb2.c> r107 = r210.f545242a;
        if ((r107 instanceof Collection) == true) goto L65;
    L67:
        Iterator<T> r108 = r107.iterator();
    L69:
        if (r108.hasNext() == false) goto L75;
        if (((tb2.c) r108.next()).getImageValue() == null) goto L73;
        boolean r109 = true;
    L74:
        if (r109 == false) goto L69;
    L73:
        r109 = false;
    L75:
        Unit r112 = Unit.INSTANCE;
        r212.b(r105, r106);
        return;
    L65:
        if (r107.isEmpty() == false) goto L67;
    L76:
        c r113 = new c(r212);
        Intrinsics.checkNotNullParameter(r100, "toLoadSpan");
        if ((!r100.f141013b.isEmpty()) == false) goto L121;
        b r114 = new b(r100, r113, r211);
        a r115 = f141032d;
        List<com.bytedance.android.livesdk.interactivity.service.textrender.core.b> r116 = r100.f141013b;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "asyncInfo");
        final j r117 = new j(r116);
        Intrinsics.checkNotNullParameter(r114, "listener");
        if (r117.f141021d.isEmpty() == true) goto L122;
        r117.f141019b = r114;
        int r118 = r117.f141021d.size();
        final int r119 = 0;
    L82:
        if (r119 >= r118) goto L123;
        int r120 = ((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r117.f141021d, r119)).f141006c.getType();
        if (r120 != PieceType.GIFT.getPieceType()) goto L93;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r121 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r117.f141021d, r119);
        if (((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r117.f141021d, r119)).f141006c.getGiftValue() != null) goto L88;
    L91:
        r117.b(r119, null);
    L102:
        r119 = r119 + 1;
        goto L82
    L88:
        if (r121.f141007d == null) goto L91;
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r121.f141007d, new k(r117, r119, r121));
        goto L102
    L93:
        if (r120 != PieceType.IMAGE.getPieceType()) goto L101;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r122 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r117.f141021d, r119);
        ITextPieceImage r123 = ((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r117.f141021d, r119)).f141006c.getImageValue();
        if (r123 != null) goto L97;
        r117.b(r119, null);
        goto L102
    L97:
        i r124 = b(r123);
        if (r124 != null) goto L100;
        r117.b(r119, null);
        goto L102
    L100:
        r124.b(r123, r122.f141010g, new ImagePiecesAsyncLoader$loadImage$1(r117, r119));
        goto L102
    L101:
        r117.b(r119, null);
        goto L102
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L57:
        r104 = false;
        goto L58
    L5:
        b5 r125 = r210.f545244c;
        yb2.a r126 = r210.f545243b;
        if (r126 == null) goto L8;
        Intrinsics.checkNotNull(r126);
    L9:
        yb2.a r127 = r126;
        StringBuilder r128 = new StringBuilder();
        Iterator<tb2.c> r129 = r210.f545242a.iterator();
    L11:
        if (r129.hasNext() == false) goto L13;
        r128.append(r129.next().getText());
        goto L11
    L13:
        if (r213 == false) goto L15;
        SpannableString r130 = new d(r128.toString());
    L16:
        SpannableString r131 = r130;
        r131.setSpan(new ForegroundColorSpan(w.b(PieceType.STRING.getPieceType(), null, r125, r127)), 0, r131.length(), 18);
        ArrayList r132 = new ArrayList();
        Iterator<tb2.c> r133 = r210.f545242a.iterator();
        int r134 = 0;
    L18:
        if (r133.hasNext() == false) goto L50;
        tb2.c r135 = r133.next();
        String r136 = r135.getText();
        n r137 = (n) ((HashMap) r111.f141052a).get(Integer.valueOf(r135.getType()));
        if (r137 == null) goto L30;
        Intrinsics.checkNotNullParameter(r136, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r131, "spannable");
        Intrinsics.checkNotNullParameter(r127, "parseConfig");
        Intrinsics.checkNotNullParameter(r135, "renderPiece");
        Intrinsics.checkNotNullParameter(r132, "asyncInfos");
        boolean r138 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141057a;
        if (r138 == false) goto L25;
        Logger.d("ttlive_render_engine", "start rend " + r137.f141028a.getTag());
    L25:
        String r139 = r136;
        tb2.c r140 = r135;
        b5 r141 = r125;
        x r214 = r111;
        yb2.a r142 = r127;
        int r215 = r134;
        b5 r216 = r125;
        ArrayList r143 = r132;
        yb2.a r217 = r127;
        SpannableString r144 = r131;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r145 = r137.a(r136, r131, r141, r142, r140, r215, r211);
        if (r138 == false) goto L28;
        Logger.d("ttlive_render_engine", "async : " + r145);
    L28:
        if (r145 == null) goto L31;
        r143.add(r145);
    L31:
        r140.getFormat();
        b5 r146 = r140.getFormat();
        if (r146 == null) goto L48;
        int r147 = r146.getWeight();
        if (r147 >= 700) goto L36;
        int r148 = r215;
        if (r147 > 0) goto L42;
    L45:
        int r149 = r146.getFontSize();
        if (r149 <= 0) goto L49;
        r144.setSpan(new AbsoluteSizeSpan((int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r149, r211.getScale()), true), r148, r139.length() + r148, 33);
    L49:
        r134 = r148 + r139.length();
        r132 = r143;
        r131 = r144;
        r111 = r214;
        r125 = r216;
        r127 = r217;
        goto L18
    L42:
        if (r146.isItalic() == false) goto L44;
        r144.setSpan(new StyleSpan(2), r148, r139.length() + r148, 33);
        goto L45
    L44:
        r144.setSpan(new StyleSpan(0), r148, r139.length() + r148, 33);
        goto L45
    L36:
        if (r146.isItalic() == false) goto L38;
        r148 = r215;
        r144.setSpan(new StyleSpan(3), r148, r139.length() + r148, 33);
        goto L45
    L38:
        r148 = r215;
        r144.setSpan(new StyleSpan(1), r148, r139.length() + r148, 33);
        goto L45
    L48:
        r148 = r215;
        goto L49
    L30:
        r139 = r136;
        r140 = r135;
        r215 = r134;
        r214 = r111;
        r216 = r125;
        r217 = r127;
        r143 = r132;
        r144 = r131;
        goto L31
    L50:
        ArrayList r150 = r132;
        SpannableString r151 = r131;
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141057a == false) goto L53;
        Logger.d("ttlive_render_engine", "rend async info size : " + r150.size());
    L53:
        r100 = new b0(r151, r150);
        goto L54
    L15:
        r130 = new SpannableString(r128.toString());
        goto L16
    L8:
        r126 = w.a();
        goto L9
    }

    public final void d(a5 r100, yb2.a r101, p r102, q r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r102, "rendConfig");
        Intrinsics.checkNotNullParameter(r103, "callBack");
        c(a(r100, r101), r102, r103, false);
    }
}
