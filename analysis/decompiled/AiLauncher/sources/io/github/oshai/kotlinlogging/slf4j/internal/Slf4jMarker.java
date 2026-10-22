package io.github.oshai.kotlinlogging.slf4j.internal;

import com.autonavi.aps.amapapi.config.Const;
import j8.InterfaceC4786l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.slf4j.Marker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Lio/github/oshai/kotlinlogging/slf4j/internal/Slf4jMarker;", "Lj8/l;", "Lorg/slf4j/Marker;", "", "kotlin.jvm.PlatformType", "getName", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lorg/slf4j/Marker;", "()Lorg/slf4j/Marker;", "marker", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Slf4jMarker implements InterfaceC4786l, Marker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Marker marker;

    /* renamed from: a, reason: from getter */
    public final Marker getMarker() {
        return this.marker;
    }

    @Override // j8.InterfaceC4786l, org.slf4j.Marker
    public String getName() {
        String name = this.marker.getName();
        p.h(name, "getName(...)");
        return name;
    }
}
