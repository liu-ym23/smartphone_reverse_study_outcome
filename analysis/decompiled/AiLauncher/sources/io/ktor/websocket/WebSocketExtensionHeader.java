package io.ktor.websocket;

import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionHeader;", "", "", "name", "", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "parametersToString", "()Ljava/lang/String;", "LKa/j;", "Lkotlin/Pair;", "parseParameters", "()LKa/j;", "toString", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketExtensionHeader {
    private final String name;
    private final List<String> parameters;

    public WebSocketExtensionHeader(String name, List<String> parameters) {
        p.i(name, "name");
        p.i(parameters, "parameters");
        this.name = name;
        this.parameters = parameters;
    }

    private final String parametersToString() {
        if (this.parameters.isEmpty()) {
            return "";
        }
        return "; " + F.A0(this.parameters, Const.STR_MART_SEMICOLON, null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseParameters$lambda$0(String it) {
        p.i(it, "it");
        int iT0 = H.t0(it, '=', 0, false, 6, null);
        String strSubstring = "";
        if (iT0 < 0) {
            return Y8.j.a(it, "");
        }
        String strL1 = H.l1(it, C5685n.s(0, iT0));
        int i10 = iT0 + 1;
        if (i10 < it.length()) {
            strSubstring = it.substring(i10);
            p.h(strSubstring, "substring(...)");
        }
        return Y8.j.a(strL1, strSubstring);
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getParameters() {
        return this.parameters;
    }

    public final Ka.j<Pair<String, String>> parseParameters() {
        return SequencesKt___SequencesKt.R(F.d0(this.parameters), new InterfaceC5074l() { // from class: io.ktor.websocket.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WebSocketExtensionHeader.parseParameters$lambda$0((String) obj);
            }
        });
    }

    public String toString() {
        return this.name + ' ' + parametersToString();
    }
}
