package ah9;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.bean.RequestType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpeakerVoice> f3446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f3448c;

    public c() {
        this(null, null, null, RequestType.INIT);
    }

    public c(List r100, Integer r101, Integer r102, RequestType r103) {
        Intrinsics.checkNotNullParameter(r103, "requestType");
        this.f3446a = r100;
        this.f3447b = r101;
        this.f3448c = r102;
    }
}
