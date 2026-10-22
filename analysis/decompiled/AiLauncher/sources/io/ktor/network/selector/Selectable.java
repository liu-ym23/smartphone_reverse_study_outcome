package io.ktor.network.selector;

import Ua.InterfaceC1045a0;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.io.Closeable;
import java.nio.channels.SelectableChannel;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lio/ktor/network/selector/Selectable;", "Ljava/io/Closeable;", "LUa/a0;", "Lio/ktor/network/selector/SelectInterest;", "interest", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "interestOp", "(Lio/ktor/network/selector/SelectInterest;Z)V", "Lio/ktor/network/selector/InterestSuspensionsMap;", "getSuspensions", "()Lio/ktor/network/selector/InterestSuspensionsMap;", "suspensions", "isClosed", "()Z", "", "getInterestedOps", "()I", "interestedOps", "Ljava/nio/channels/SelectableChannel;", "getChannel", "()Ljava/nio/channels/SelectableChannel;", "channel", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Selectable extends Closeable, InterfaceC1045a0 {
    @Override // Ua.InterfaceC1045a0
    /* synthetic */ void dispose();

    SelectableChannel getChannel();

    int getInterestedOps();

    InterestSuspensionsMap getSuspensions();

    void interestOp(SelectInterest interest, boolean state);

    boolean isClosed();
}
