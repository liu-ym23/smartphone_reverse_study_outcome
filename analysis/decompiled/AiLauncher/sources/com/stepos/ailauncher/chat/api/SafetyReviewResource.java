package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewResource;", "", "id", "", "name", "type", HomeGestureEligibilityContract.EXTRA_SCENE, "context", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getScene", "getContext", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewResource {
    private final String context;
    private final String id;
    private final String name;
    private final String scene;
    private final String type;

    public SafetyReviewResource(String id, String str, String type, String scene, String context) {
        p.i(id, "id");
        p.i(type, "type");
        p.i(scene, "scene");
        p.i(context, "context");
        this.id = id;
        this.name = str;
        this.type = type;
        this.scene = scene;
        this.context = context;
    }

    public static /* synthetic */ SafetyReviewResource copy$default(SafetyReviewResource safetyReviewResource, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewResource.id;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewResource.name;
        }
        if ((i10 & 4) != 0) {
            str3 = safetyReviewResource.type;
        }
        if ((i10 & 8) != 0) {
            str4 = safetyReviewResource.scene;
        }
        if ((i10 & 16) != 0) {
            str5 = safetyReviewResource.context;
        }
        String str6 = str5;
        String str7 = str3;
        return safetyReviewResource.copy(str, str2, str7, str4, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContext() {
        return this.context;
    }

    public final SafetyReviewResource copy(String id, String name, String type, String scene, String context) {
        p.i(id, "id");
        p.i(type, "type");
        p.i(scene, "scene");
        p.i(context, "context");
        return new SafetyReviewResource(id, name, type, scene, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewResource)) {
            return false;
        }
        SafetyReviewResource safetyReviewResource = (SafetyReviewResource) other;
        return p.d(this.id, safetyReviewResource.id) && p.d(this.name, safetyReviewResource.name) && p.d(this.type, safetyReviewResource.type) && p.d(this.scene, safetyReviewResource.scene) && p.d(this.context, safetyReviewResource.context);
    }

    public final String getContext() {
        return this.context;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.context.hashCode();
    }

    public String toString() {
        return "SafetyReviewResource(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", scene=" + this.scene + ", context=" + this.context + ")";
    }

    public /* synthetic */ SafetyReviewResource(String str, String str2, String str3, String str4, String str5, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, str3, str4, str5);
    }
}
