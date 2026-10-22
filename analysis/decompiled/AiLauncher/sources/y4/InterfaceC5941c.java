package y4;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.C5732a;
import x5.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Ly4/c;", "Ly4/a;", "Lw4/a;", "agentInfo", "LY8/t;", "setAgentInfo", "(Lw4/a;)V", "Lkotlin/Function1;", "", "listener", "setOnBtnPlaySoundClickedListener", "(Lp9/l;)V", "Lkotlin/Function0;", "setOnBtnNewChatClickedListener", "(Lp9/a;)V", "setOnBtnClearContextClickedListener", "setOnBtnAudioCallClickedListener", d.EXTRA_ENABLED, "setBtnClearContextEnabled", "(Z)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: y4.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5941c extends InterfaceC5939a {
    void setAgentInfo(C5732a agentInfo);

    default void setBtnClearContextEnabled(boolean enabled) {
    }

    default void setOnBtnAudioCallClickedListener(InterfaceC5063a<t> listener) {
    }

    default void setOnBtnClearContextClickedListener(InterfaceC5063a<t> listener) {
    }

    default void setOnBtnNewChatClickedListener(InterfaceC5063a<t> listener) {
    }

    default void setOnBtnPlaySoundClickedListener(InterfaceC5074l<? super Boolean, t> listener) {
        p.i(listener, "listener");
    }
}
