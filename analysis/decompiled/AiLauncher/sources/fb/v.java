package fb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0012H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001dH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0000H&¢\u0006\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&\u0082\u0001\u0002$*ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0001"}, d2 = {"Lfb/v;", "Lfb/k;", "", "k", "()Z", "", "byteCount", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "()J", "", "sink", "startIndex", "endIndex", "G0", "([BII)I", "Lfb/j;", "E0", "(Lfb/j;J)V", "B", "(Lfb/j;)J", "peek", "()Lfb/v;", "Lfb/a;", Const.INTENT_KEY_APIKEY, "()Lfb/a;", "getBuffer$annotations", "()V", "buffer", "Lfb/m;", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface v extends InterfaceC4084k {
    long B(InterfaceC4083j sink);

    void E0(InterfaceC4083j sink, long byteCount);

    int G0(byte[] sink, int startIndex, int endIndex);

    C4074a a();

    void j(long byteCount);

    boolean k();

    v peek();

    byte readByte();

    int readInt();

    long readLong();

    short readShort();

    boolean request(long byteCount);
}
