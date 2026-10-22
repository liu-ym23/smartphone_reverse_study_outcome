package am8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchAppletCardItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements usc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zl8.e f4423a;

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, usc.e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final View asView() {
        return this.f4423a.b();
    }

    @Override // usc.f
    public final void f() {
        this.f4423a.c();
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f4423a = new zl8.e(r100);
    }

    @Override // usc.f
    public final Size d(TextView r210, Spanned r211, final usc.e r212, int r213, Map<String, ? extends Object> r214) {
        Intrinsics.checkNotNullParameter(r210, "textView");
        Intrinsics.checkNotNullParameter(r211, "text");
        Intrinsics.checkNotNullParameter(r212, "span");
        boolean r110 = Intrinsics.areEqual(r212.i(), "data-block-full");
        ContainerAttribute r100 = null;
        if (r214 == null) goto L5;
        Object r101 = r214.get("markdown_common_input_data");
    L7:
        if ((r101 instanceof fh8.f) == false) goto L9;
        final fh8.f r102 = (fh8.f) r101;
    L10:
        if (r102 == null) goto L12;
        final Message r111 = r102.f477072b;
    L13:
        wc8.b r103 = wc8.b.f559187a;
        if (r111 == null) goto L16;
        String r104 = r111.getMessageId();
    L17:
        RichMediaMeta r105 = r103.h(r104, r212.k(), "MarkdownAppletWidget");
        if (r105 == null) goto L26;
        List<RichMediaItem> r106 = r105.getMedia();
        if (r106 == null) goto L26;
        RichMediaItem r107 = (RichMediaItem) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L26;
        SearchAppletCardItem r108 = r107.applet;
        if (r108 == null) goto L26;
        String r109 = r108.renderData;
    L28:
        if (r109 == null) goto L30;
    L41:
        String r112 = r109;
        if (r211.getSpanStart(r212) != 0) goto L44;
        boolean r113 = true;
    L46:
        if (r211.getSpanEnd(r212) != r211.length()) goto L48;
        boolean r114 = true;
    L49:
        if (r111 == null) goto L51;
        String r115 = r111.getMessageId();
    L52:
        RichMediaMeta r116 = r103.h(r115, r212.k(), "MarkdownAppletWidget");
        if (r116 == null) goto L55;
        r100 = r116.getContainerAttribute();
    L55:
        if (r100 == null) goto L57;
        boolean r117 = Intrinsics.areEqual(r100.isFullWidth(), Boolean.TRUE);
    L58:
        if (r117 == false) goto L65;
        if (r102 == null) goto L63;
        Integer r118 = r102.f477093w;
        if (r118 == null) goto L63;
        int r119 = r118.intValue();
    L64:
        int r120 = (r119 + r210.getPaddingStart()) + r210.getPaddingEnd();
    L66:
        cm8.f r121 = new cm8.f(r120, r112, r111, null, false, r110, r113, r114, r117, r210.getPaddingStart(), r210.getPaddingEnd(), new a(r212, r111, r102));
        this.f4423a.a(r121, new cm8.e(r102));
        return this.f4423a.e(r121);
    L63:
        r119 = r213;
        goto L64
    L65:
        r120 = r213;
        goto L66
    L57:
        r117 = false;
        goto L58
    L51:
        r115 = null;
        goto L52
    L48:
        r114 = false;
        goto L49
    L44:
        r113 = false;
        goto L46
    L30:
        if (r212.k().length() != 0) goto L32;
        boolean r122 = true;
    L33:
        if (r122 == false) goto L35;
        r109 = r212.h();
    L39:
        if (r109 != null) goto L41;
        r109 = SliceInitService.DEFAULT_SWITCH;
        goto L41
    L35:
        if (r111 == null) goto L37;
        String r123 = r111.getMessageId();
    L38:
        r109 = r103.c(r123, r212.k(), "MarkdownAppletWidget");
        goto L39
    L37:
        r123 = null;
        goto L38
    L32:
        r122 = false;
    L26:
        r109 = null;
        goto L28
    L16:
        r104 = null;
        goto L17
    L12:
        r111 = null;
        goto L13
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }
}
