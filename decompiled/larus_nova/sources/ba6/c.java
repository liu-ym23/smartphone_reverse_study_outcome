package ba6;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    String a();

    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "getNodeKey()", imports = {}))
    String d();

    Map<String, Object> e();

    String getNodeName();

    String getPosition();

    boolean m();

    @Deprecated(message = "SDK内部API")
    void p(Function1<? super Map<String, Object>, Unit> r100);
}
