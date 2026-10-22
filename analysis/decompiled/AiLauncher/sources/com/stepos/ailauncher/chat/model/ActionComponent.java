package com.stepos.ailauncher.chat.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/model/ActionComponent;", "", "type", "", "options", "", "Lcom/stepos/ailauncher/chat/model/ActionOption;", "media", "Lcom/stepos/ailauncher/chat/model/ActionMedia;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/chat/model/ActionMedia;)V", "getType", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "getMedia", "()Lcom/stepos/ailauncher/chat/model/ActionMedia;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionComponent {
    private final ActionMedia media;
    private final List<ActionOption> options;
    private final String type;

    public ActionComponent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionComponent copy$default(ActionComponent actionComponent, String str, List list, ActionMedia actionMedia, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionComponent.type;
        }
        if ((i10 & 2) != 0) {
            list = actionComponent.options;
        }
        if ((i10 & 4) != 0) {
            actionMedia = actionComponent.media;
        }
        return actionComponent.copy(str, list, actionMedia);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<ActionOption> component2() {
        return this.options;
    }

    /* renamed from: component3, reason: from getter */
    public final ActionMedia getMedia() {
        return this.media;
    }

    public final ActionComponent copy(String type, List<ActionOption> options, ActionMedia media) {
        return new ActionComponent(type, options, media);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionComponent)) {
            return false;
        }
        ActionComponent actionComponent = (ActionComponent) other;
        return p.d(this.type, actionComponent.type) && p.d(this.options, actionComponent.options) && p.d(this.media, actionComponent.media);
    }

    public final ActionMedia getMedia() {
        return this.media;
    }

    public final List<ActionOption> getOptions() {
        return this.options;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ActionOption> list = this.options;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        ActionMedia actionMedia = this.media;
        return iHashCode2 + (actionMedia != null ? actionMedia.hashCode() : 0);
    }

    public String toString() {
        return "ActionComponent(type=" + this.type + ", options=" + this.options + ", media=" + this.media + ")";
    }

    public ActionComponent(String str, List<ActionOption> list, ActionMedia actionMedia) {
        this.type = str;
        this.options = list;
        this.media = actionMedia;
    }

    public /* synthetic */ ActionComponent(String str, List list, ActionMedia actionMedia, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list, (i10 & 4) != 0 ? null : actionMedia);
    }
}
