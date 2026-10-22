package com.stepos.motionkit;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ<\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\rR)\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/stepos/motionkit/AnimationDefinition;", "", "", "Lcom/stepos/motionkit/TrackDefinition;", "tracks", "", "", "Lkotlin/Function0;", "LC7/r;", "completionActions", AppAgent.CONSTRUCT, "(Ljava/util/List;Ljava/util/Map;)V", "component1", "()Ljava/util/List;", "component2", "()Ljava/util/Map;", "copy", "(Ljava/util/List;Ljava/util/Map;)Lcom/stepos/motionkit/AnimationDefinition;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTracks", "Ljava/util/Map;", "getCompletionActions", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AnimationDefinition {
    private final Map<String, a> completionActions;
    private final List<TrackDefinition> tracks;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationDefinition(List<TrackDefinition> tracks, Map<String, ? extends a> completionActions) {
        k.f(tracks, "tracks");
        k.f(completionActions, "completionActions");
        this.tracks = tracks;
        this.completionActions = completionActions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimationDefinition copy$default(AnimationDefinition animationDefinition, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = animationDefinition.tracks;
        }
        if ((i & 2) != 0) {
            map = animationDefinition.completionActions;
        }
        return animationDefinition.copy(list, map);
    }

    public final List<TrackDefinition> component1() {
        return this.tracks;
    }

    public final Map<String, a> component2() {
        return this.completionActions;
    }

    public final AnimationDefinition copy(List<TrackDefinition> tracks, Map<String, ? extends a> completionActions) {
        k.f(tracks, "tracks");
        k.f(completionActions, "completionActions");
        return new AnimationDefinition(tracks, completionActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationDefinition)) {
            return false;
        }
        AnimationDefinition animationDefinition = (AnimationDefinition) other;
        return k.b(this.tracks, animationDefinition.tracks) && k.b(this.completionActions, animationDefinition.completionActions);
    }

    public final Map<String, a> getCompletionActions() {
        return this.completionActions;
    }

    public final List<TrackDefinition> getTracks() {
        return this.tracks;
    }

    public int hashCode() {
        return this.completionActions.hashCode() + (this.tracks.hashCode() * 31);
    }

    public String toString() {
        return "AnimationDefinition(tracks=" + this.tracks + ", completionActions=" + this.completionActions + ")";
    }

    public /* synthetic */ AnimationDefinition(List list, Map map, int i, e eVar) {
        this(list, (i & 2) != 0 ? kotlin.collections.a.M() : map);
    }
}
