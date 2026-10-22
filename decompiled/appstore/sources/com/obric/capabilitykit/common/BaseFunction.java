package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.gson.JsonObject;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt__StringsKt;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "migration to intent api")
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/common/BaseFunction;", "", "name", "", "getName", "()Ljava/lang/String;", "doAction", "Lcom/obric/capabilitykit/common/BaseResult;", "params", "Lcom/google/gson/JsonObject;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/google/gson/JsonObject;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "", "translateTimeIntoUTC", "", "input", "translateUTCIntoTime", "time", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BaseFunction {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static long a(@NotNull BaseFunction r12, @NotNull String r13) {
            kotlin.jvm.internal.q.g(r13, "input");
            List r14 = StringsKt__StringsKt.l0(kotlin.text.o.x(r13, "-", "#", false, 4, null), new String[]{"#"}, false, 0, 6, null);
            if (r14.size() < 3) goto L12;
            int r10 = Integer.parseInt((String) r14.get(0));
            int r11 = Integer.parseInt((String) r14.get(1)) - 1;
            int r15 = Integer.parseInt((String) r14.get(2));
            String r16 = (String) kotlin.collections.b0.a0(r14, 3);
            String r17 = AdReportParam.ClickPosType.SKIP;
            if (r16 != null) goto L7;
            r16 = AdReportParam.ClickPosType.SKIP;
        L7:
            int r18 = Integer.parseInt(r16);
            String r19 = (String) kotlin.collections.b0.a0(r14, 4);
            if (r19 == null) goto L11;
            r17 = r19;
        L11:
            int r20 = Integer.parseInt(r17);
            Calendar r110 = Calendar.getInstance();
            r110.setTimeZone(TimeZone.getDefault());
            r110.set(r10, r11, r15, r18, r20, 0);
            r110.set(14, 0);
            return r110.getTimeInMillis();
        L12:
            return -1;
        }

        @NotNull
        public static String a(@NotNull BaseFunction r10, long r11) {
            Calendar r12 = Calendar.getInstance();
            r12.setTimeInMillis(r11);
            r12.setTimeZone(TimeZone.getDefault());
            int r13 = r12.get(1);
            int r14 = r12.get(2) + 1;
            int r15 = r12.get(5);
            int r16 = r12.get(11);
            int r17 = r12.get(12);
            StringBuilder r18 = new StringBuilder();
            r18.append(r13);
            r18.append('/');
            r18.append(r14);
            r18.append('/');
            r18.append(r15);
            r18.append(TokenParser.SP);
            r18.append(r16);
            r18.append(':');
            r18.append(r17);
            return r18.toString();
        }

        public static boolean a(@NotNull BaseFunction r10) {
            return false;
        }
    }

    @Nullable
    Object doAction(@NotNull JsonObject r10, @NotNull DispatchContext r11, @NotNull Continuation<? super BaseResult> r12);

    @NotNull
    String getName();

    boolean isBlock();

    long translateTimeIntoUTC(@NotNull String r10);

    @NotNull
    String translateUTCIntoTime(long r10);
}
