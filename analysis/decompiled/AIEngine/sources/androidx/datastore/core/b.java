package androidx.datastore.core;

import androidx.datastore.preferences.protobuf.b1;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static c a(List migrations, CoroutineScope coroutineScope, zb.a aVar) {
        g.f(migrations, "migrations");
        return new c(aVar, b1.P(new DataMigrationInitializer$Companion$getInitializer$1(migrations, null)), new b1(7), coroutineScope);
    }
}
