package com.mdisdk.action;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/mdisdk/action/KeyEventArgs;", "", "keyCode", "", WindowStateInfo.KEY_DISPLAY_ID, AppAgent.CONSTRUCT, "(ILjava/lang/Integer;)V", "getKeyCode", "()I", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/mdisdk/action/KeyEventArgs;", "equals", "", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KeyEventArgs {
    private final Integer displayId;
    private final int keyCode;

    public KeyEventArgs(int i, Integer num) {
        this.keyCode = i;
        this.displayId = num;
    }

    public static /* synthetic */ KeyEventArgs copy$default(KeyEventArgs keyEventArgs, int i, Integer num, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = keyEventArgs.keyCode;
        }
        if ((i6 & 2) != 0) {
            num = keyEventArgs.displayId;
        }
        return keyEventArgs.copy(i, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getKeyCode() {
        return this.keyCode;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final KeyEventArgs copy(int keyCode, Integer displayId) {
        return new KeyEventArgs(keyCode, displayId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyEventArgs)) {
            return false;
        }
        KeyEventArgs keyEventArgs = (KeyEventArgs) other;
        return this.keyCode == keyEventArgs.keyCode && k.b(this.displayId, keyEventArgs.displayId);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final int getKeyCode() {
        return this.keyCode;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.keyCode) * 31;
        Integer num = this.displayId;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "KeyEventArgs(keyCode=" + this.keyCode + ", displayId=" + this.displayId + ')';
    }
}
