package ai9;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.larkfeed.impl.voice.FlowVoiceFactory;
import com.larus.media.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f3858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f3859b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f3858a, r101.f3858a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3859b, r101.f3859b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f3858a.hashCode() * 31) + this.f3859b.hashCode();
    }

    public final String toString() {
        return "VoiceServiceContext(fragment=" + this.f3858a + ", mediaStateListener=" + this.f3859b + ')';
    }

    public b(Fragment r100, FlowVoiceFactory.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "mediaStateListener");
        this.f3858a = r100;
        this.f3859b = r101;
    }
}
