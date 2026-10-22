package com.stepos.ailauncher.container;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u001b\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00138\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/container/Z;", "", "<init>", "()V", "", "hasContent", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Z)V", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "c", "", "Lcom/stepos/ailauncher/container/Y;", "list", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)V", "LXa/k;", "_hasContent", "LXa/k;", "LXa/t;", "LXa/t;", "getHasContent", "()LXa/t;", "_isRecording", "isRecording", "_attachments", "attachments", "getAttachments", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    public static final Z INSTANCE = new Z();
    private static final Xa.k<List<OverlayAttachmentPreview>> _attachments;
    private static final Xa.k<Boolean> _hasContent;
    private static final Xa.k<Boolean> _isRecording;
    private static final Xa.t<List<OverlayAttachmentPreview>> attachments;
    private static final Xa.t<Boolean> hasContent;
    private static final Xa.t<Boolean> isRecording;

    static {
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA = Xa.u.a(bool);
        _hasContent = kVarA;
        hasContent = Xa.d.c(kVarA);
        Xa.k<Boolean> kVarA2 = Xa.u.a(bool);
        _isRecording = kVarA2;
        isRecording = Xa.d.c(kVarA2);
        Xa.k<List<OverlayAttachmentPreview>> kVarA3 = Xa.u.a(C1173v.m());
        _attachments = kVarA3;
        attachments = Xa.d.c(kVarA3);
    }

    public final void a(boolean hasContent2) {
        _hasContent.setValue(Boolean.valueOf(hasContent2));
    }

    public final void b(List<OverlayAttachmentPreview> list) {
        kotlin.jvm.internal.p.i(list, "list");
        _attachments.setValue(list);
    }

    public final void c(boolean recording) {
        _isRecording.setValue(Boolean.valueOf(recording));
    }
}
