package tb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import kotlin.Metadata;
import vb.C5688a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltb/b;", "", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "Ltb/C;", UxipConstants.f30685x, "Ltb/A;", "authenticate", "(Ltb/E;Ltb/C;)Ltb/A;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5535b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f42161a;

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5535b f42159b = new Companion.C0530a();

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC5535b f42160c = new C5688a(null, 1, 0 == true ? 1 : 0);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001R\u0017\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\u0001¨\u0006\t"}, d2 = {"Ltb/b$a;", "", "<init>", "()V", "Ltb/b;", ModelFlowMeta.PLAN_NONE, "Ltb/b;", "JAVA_NET_AUTHENTICATOR", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.b$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f42161a = new Companion();

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltb/b$a$a;", "Ltb/b;", "<init>", "()V", "Ltb/E;", M5.a.CARD_TYPE_ROUTE, "Ltb/C;", UxipConstants.f30685x, "Ltb/A;", "authenticate", "(Ltb/E;Ltb/C;)Ltb/A;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.b$a$a, reason: collision with other inner class name */
        public static final class C0530a implements InterfaceC5535b {
            @Override // tb.InterfaceC5535b
            public C5528A authenticate(C5532E route, C5530C response) {
                kotlin.jvm.internal.p.i(response, "response");
                return null;
            }
        }
    }

    C5528A authenticate(C5532E route, C5530C response) throws IOException;
}
