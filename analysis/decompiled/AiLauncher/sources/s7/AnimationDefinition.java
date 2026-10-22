package s7;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R)\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u0015\u0010\u001a¨\u0006\u001b"}, d2 = {"Ls7/a;", "", "", "Ls7/u;", "tracks", "", "", "Lkotlin/Function0;", "LY8/t;", "completionActions", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Ljava/util/Map;", "()Ljava/util/Map;", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: s7.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final /* data */ class AnimationDefinition {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<TrackDefinition> tracks;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, InterfaceC5063a<Y8.t>> completionActions;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationDefinition(List<TrackDefinition> tracks, Map<String, ? extends InterfaceC5063a<Y8.t>> completionActions) {
        kotlin.jvm.internal.p.i(tracks, "tracks");
        kotlin.jvm.internal.p.i(completionActions, "completionActions");
        this.tracks = tracks;
        this.completionActions = completionActions;
    }

    public final Map<String, InterfaceC5063a<Y8.t>> a() {
        return this.completionActions;
    }

    public final List<TrackDefinition> b() {
        return this.tracks;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationDefinition)) {
            return false;
        }
        AnimationDefinition animationDefinition = (AnimationDefinition) other;
        return kotlin.jvm.internal.p.d(this.tracks, animationDefinition.tracks) && kotlin.jvm.internal.p.d(this.completionActions, animationDefinition.completionActions);
    }

    public int hashCode() {
        return (this.tracks.hashCode() * 31) + this.completionActions.hashCode();
    }

    public String toString() {
        return "AnimationDefinition(tracks=" + this.tracks + ", completionActions=" + this.completionActions + ")";
    }
}
