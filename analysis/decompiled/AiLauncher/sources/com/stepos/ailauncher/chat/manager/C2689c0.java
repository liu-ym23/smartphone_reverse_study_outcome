package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/c0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "source", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)V", "target", Const.INTENT_KEY_APIKEY, "c", "Lcom/stepos/ailauncher/chat/manager/c0$a;", AuthSessionDto.STATUS_PENDING, "Lcom/stepos/ailauncher/chat/manager/c0$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2689c0 {
    public static final C2689c0 INSTANCE = new C2689c0();
    private static Snapshot pending;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/c0$a;", "", "", "text", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "attachments", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "c", "()Z", "isEmpty", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.c0$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final List<FileInfo> attachments;
        private final String text;

        public Snapshot(String text, List<FileInfo> attachments) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(attachments, "attachments");
            this.text = text;
            this.attachments = attachments;
        }

        public final List<FileInfo> a() {
            return this.attachments;
        }

        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final boolean c() {
            return this.text.length() == 0 && this.attachments.isEmpty();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return kotlin.jvm.internal.p.d(this.text, snapshot.text) && kotlin.jvm.internal.p.d(this.attachments, snapshot.attachments);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.attachments.hashCode();
        }

        public String toString() {
            return "Snapshot(text=" + this.text + ", attachments=" + this.attachments + ")";
        }
    }

    public final void a(BaseInputView target) {
        kotlin.jvm.internal.p.i(target, "target");
        Snapshot snapshot = pending;
        if (snapshot == null) {
            return;
        }
        pending = null;
        if (snapshot.getText().length() > 0) {
            target.setInputTxt(snapshot.getText());
        }
        target.ra(snapshot.a());
    }

    public final void b(BaseInputView source) {
        kotlin.jvm.internal.p.i(source, "source");
        Snapshot snapshot = new Snapshot(source.ec(), source.dc());
        if (snapshot.c()) {
            pending = null;
        } else {
            pending = snapshot;
        }
    }

    public final void c() {
        pending = null;
    }
}
