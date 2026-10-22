package androidx.activity;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.CodedOutputStream;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ String A(int i) {
        switch (i) {
            case 1:
                return "Alias";
            case 2:
                return "Anchor";
            case 3:
                return "BlockEnd";
            case 4:
                return "BlockEntry";
            case 5:
                return "BlockMappingStart";
            case 6:
                return "BlockSequenceStart";
            case 7:
                return "Directive";
            case 8:
                return "DocumentEnd";
            case 9:
                return "DocumentStart";
            case 10:
                return "FlowEntry";
            case 11:
                return "FlowMappingEnd";
            case 12:
                return "FlowMappingStart";
            case 13:
                return "FlowSequenceEnd";
            case 14:
                return "FlowSequenceStart";
            case 15:
                return "Key";
            case 16:
                return "Scalar";
            case 17:
                return "StreamEnd";
            case 18:
                return "StreamStart";
            case 19:
                return "Tag";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return "Value";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return "Whitespace";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return "Comment";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return "Error";
            default:
                return "null";
        }
    }

    public static final boolean a(int i) {
        return i == 3 || i == 4 || i == 6;
    }

    public static /* synthetic */ String b(int i) {
        switch (i) {
            case 1:
                return "object";
            case 2:
                return "array";
            case 3:
                return "string";
            case 4:
                return "number";
            case 5:
                return "integer";
            case 6:
                return "boolean";
            case 7:
                return "null";
            case 8:
                return "any";
            case 9:
                return "unknown";
            case 10:
                return "union";
            default:
                throw null;
        }
    }

    public static int c(int i, int i3, int i10, int i11) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i3 + i10 + i11;
    }

    public static int d(int i, int i3, String str) {
        return (str.hashCode() + i) * i3;
    }

    public static int e(List list, int i, int i3) {
        return (list.hashCode() + i) * i3;
    }

    public static int f(Map map, int i, int i3) {
        return (Objects.hashCode(map) + i) * i3;
    }

    public static ClassCastException g(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String h(RecyclerView recyclerView, StringBuilder sb2) {
        sb2.append(recyclerView.exceptionLabel());
        return sb2.toString();
    }

    public static String i(String str, int i, String str2, int i3) {
        return str + i + str2 + i3;
    }

    public static String j(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String k(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String l(StringBuilder sb2, int i, char c9) {
        sb2.append(i);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String m(StringBuilder sb2, Class cls, String str) {
        sb2.append(cls.getName());
        sb2.append(str);
        return sb2.toString();
    }

    public static String n(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static StringBuilder o(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder p(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static Mono q(String str) {
        return Mono.error(new IllegalStateException(str));
    }

    public static void r(Context context, int i, LinkedHashMap linkedHashMap, String str) {
        String string = context.getString(i);
        string.getClass();
        linkedHashMap.put(str, string);
    }

    public static /* synthetic */ void s(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            od.f.b();
            return;
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z10 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z10) {
                    executorService.shutdownNow();
                    z10 = true;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public static void t(StringBuilder sb2, Class cls, String str) {
        sb2.append(cls.getSimpleName());
        sb2.append(str);
    }

    public static void u(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }

    public static void v(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static int w(int i, int i3, String str) {
        return (Objects.hashCode(str) + i) * i3;
    }

    public static int x(List list, int i, int i3) {
        return (Objects.hashCode(list) + i) * i3;
    }

    public static /* synthetic */ String y(int i) {
        switch (i) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String z(int i) {
        switch (i) {
            case 1:
                return "ENQUEUED";
            case 2:
                return "RUNNING";
            case 3:
                return "SUCCEEDED";
            case 4:
                return "FAILED";
            case 5:
                return "BLOCKED";
            case 6:
                return "CANCELLED";
            default:
                return "null";
        }
    }
}
