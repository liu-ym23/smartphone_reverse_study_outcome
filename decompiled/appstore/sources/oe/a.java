package oe;

import com.bytedanceos.common.toolbox.j;
import ec.d;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final void a(String r10, Function0 r11) {
        q.g(r10, "<this>");
        q.g(r11, "param");
        j.e("reportMobEvent:name =  " + r10 + "   param = " + r11.invoke());
        d.f19371l.a().x(r10, new JSONObject((Map) r11.invoke()));
    }
}
