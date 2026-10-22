package com.stepos.motionkit.fx.anim;

import S7.a;
import S7.k;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.motionkit.AnimationDefinition;
import com.stepos.motionkit.TrackDefinition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/motionkit/fx/anim/AnimationBuilder;", "", AppAgent.CONSTRUCT, "()V", "", HintConstants.AUTOFILL_HINT_NAME, "", "component", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/anim/TrackBuilder;", "LC7/r;", "block", "track", "(Ljava/lang/String;ILS7/k;)V", "trackName", "Lkotlin/Function0;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "onComplete", "(Ljava/lang/String;LS7/a;)V", "Lcom/stepos/motionkit/AnimationDefinition;", "build$motionkit_fx_release", "()Lcom/stepos/motionkit/AnimationDefinition;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "Lcom/stepos/motionkit/TrackDefinition;", "tracks", "Ljava/util/List;", "", "completionActions", "Ljava/util/Map;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AnimationBuilder {
    private final List<TrackDefinition> tracks = new ArrayList();
    private final Map<String, a> completionActions = new LinkedHashMap();

    public static /* synthetic */ void track$default(AnimationBuilder animationBuilder, String str, int i, k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = -1;
        }
        animationBuilder.track(str, i, kVar);
    }

    public final AnimationDefinition build$motionkit_fx_release() {
        return new AnimationDefinition(this.tracks, this.completionActions);
    }

    public final void onComplete(String trackName, a action) {
        kotlin.jvm.internal.k.f(trackName, "trackName");
        kotlin.jvm.internal.k.f(action, "action");
        this.completionActions.put(trackName, action);
    }

    public final void track(String name, int component, k block) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(block, "block");
        List<TrackDefinition> list = this.tracks;
        TrackBuilder trackBuilder = new TrackBuilder(name, component);
        block.invoke(trackBuilder);
        list.add(trackBuilder.build$motionkit_fx_release());
    }
}
