package az7;

import com.larksuite.component.card.component.audio.service.CardAudioStateEntity;
import com.larksuite.component.card.component.audio.service.c;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zy7.c f16809a;

    public a(zy7.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventService");
        this.f16809a = r100;
    }

    @Override // com.larksuite.component.card.component.audio.service.c
    public final void a(String r100, CardAudioStateEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionID");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f16809a.k(CollectionsKt.listOf(JavaOnlyMap.from(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("sessionID", r100), TuplesKt.to("audio", JavaOnlyMap.from(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("state", r101.getState().getValue()), TuplesKt.to("position", Integer.valueOf(r101.getPosition())), TuplesKt.to("duration", Integer.valueOf(r101.getDuration()))})))}))));
    }
}
