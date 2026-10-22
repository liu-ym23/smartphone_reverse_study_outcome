package zb;

import Mb.InterfaceC0968f;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5531D;
import tb.x;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lzb/h;", "Ltb/D;", "", "contentTypeString", "", "contentLength", "LMb/f;", "source", "<init>", "(Ljava/lang/String;JLMb/f;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "Ltb/x;", "l", "()Ltb/x;", "n", "()LMb/f;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "e", "J", "f", "LMb/f;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h extends AbstractC5531D {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String contentTypeString;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final long contentLength;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f source;

    public h(String str, long j10, InterfaceC0968f source) {
        p.i(source, "source");
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = source;
    }

    @Override // tb.AbstractC5531D
    /* renamed from: i, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // tb.AbstractC5531D
    /* renamed from: l */
    public x getMediaType() {
        String str = this.contentTypeString;
        if (str != null) {
            return x.INSTANCE.b(str);
        }
        return null;
    }

    @Override // tb.AbstractC5531D
    /* renamed from: n, reason: from getter */
    public InterfaceC0968f getSource() {
        return this.source;
    }
}
