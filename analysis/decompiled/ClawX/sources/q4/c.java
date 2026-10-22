package q4;

import androidx.emoji2.text.m;
import b4.k;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c {
    static {
        JsonKt.Json$default(null, new o3.a(7), 1, null);
    }

    public static void a(b4.c cVar, Json json) {
        k4.g contentType = k4.d.f3601a;
        p.e(json, "json");
        p.e(contentType, "contentType");
        cVar.f854b.add(new b4.b(new p4.h(json), contentType, contentType.u(contentType) ? k.f881a : new m(contentType)));
    }
}
