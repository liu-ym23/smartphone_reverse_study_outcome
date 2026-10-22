package bm8;

import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.standarduikit.markdown.view.MarkdownAppletContainer;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f19637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MarkdownAppletContainer f19638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f19640d;

    public /* synthetic */ e(h r100, MarkdownAppletContainer r101, String r102, String r103) {
        this.f19637a = r100;
        this.f19638b = r101;
        this.f19639c = r102;
        this.f19640d = r103;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        h r100 = this.f19637a;
        MarkdownAppletContainer r101 = this.f19638b;
        String r102 = this.f19639c;
        String r103 = this.f19640d;
        r100.f19644a = new g();
        AppletWidget r104 = r101.f309509a;
        if (r104 == null) goto L7;
        r r105 = r104.getWidgetContainer();
        if (r105 == null) goto L7;
        r105.sendEvent("flow.chatBlur", MapsKt.mapOf(new Pair("mixture_card_id", r102)));
    L7:
        FLogger.f375446a.d("MarkdownAppletContainer", "flow.chatBlur " + r103);
        return Unit.INSTANCE;
    }
}
