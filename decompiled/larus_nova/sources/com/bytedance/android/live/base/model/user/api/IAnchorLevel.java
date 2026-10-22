package com.bytedance.android.live.base.model.user.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010 \u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010$\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010(\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\"\u0010,\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u00103\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00107\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\b\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010;\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\b\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R$\u0010?\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\b\u001a\u0004\b<\u0010/\"\u0004\b=\u00101¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "Lvh7/c;", "", "getLevel", "()I", "setLevel", "(I)V", "getLevel$annotations", "()V", "level", "", "getExperience", "()J", "setExperience", "(J)V", "getExperience$annotations", "experience", "getLowestExperienceThisLevel", "setLowestExperienceThisLevel", "getLowestExperienceThisLevel$annotations", "lowestExperienceThisLevel", "getHighestExperienceThisLevel", "setHighestExperienceThisLevel", "getHighestExperienceThisLevel$annotations", "highestExperienceThisLevel", "getTaskStartExperience", "setTaskStartExperience", "getTaskStartExperience$annotations", "taskStartExperience", "getTaskStartTime", "setTaskStartTime", "getTaskStartTime$annotations", "taskStartTime", "getTaskDecreaseExperience", "setTaskDecreaseExperience", "getTaskDecreaseExperience$annotations", "taskDecreaseExperience", "getTaskTargetExperience", "setTaskTargetExperience", "getTaskTargetExperience$annotations", "taskTargetExperience", "getTaskEndTime", "setTaskEndTime", "getTaskEndTime$annotations", "taskEndTime", "Lpy/k;", "getProfileDialogBg", "()Lpy/k;", "setProfileDialogBg", "(Lpy/k;)V", "getProfileDialogBg$annotations", "profileDialogBg", "getProfileDialogBackBg", "setProfileDialogBackBg", "getProfileDialogBackBg$annotations", "profileDialogBackBg", "getStageLevelIcon", "setStageLevelIcon", "getStageLevelIcon$annotations", "stageLevelIcon", "getLevelIcon", "setLevelIcon", "getLevelIcon$annotations", "levelIcon", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IAnchorLevel extends c<IAnchorLevel> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "experience")
    long getExperience();

    @FieldName(name = "highest_experience_this_level")
    long getHighestExperienceThisLevel();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "small_icon")
    k getLevelIcon();

    @FieldName(name = "lowest_experience_this_level")
    long getLowestExperienceThisLevel();

    @FieldName(name = "profile_dialog_bg_back")
    k getProfileDialogBackBg();

    @FieldName(name = "profile_dialog_bg")
    k getProfileDialogBg();

    @FieldName(name = "stage_level")
    k getStageLevelIcon();

    @FieldName(name = "task_decrease_experience")
    long getTaskDecreaseExperience();

    @FieldName(name = "task_end_time")
    long getTaskEndTime();

    @FieldName(name = "task_start_experience")
    long getTaskStartExperience();

    @FieldName(name = "task_start_time")
    long getTaskStartTime();

    @FieldName(name = "task_target_experience")
    long getTaskTargetExperience();

    @FieldName(name = "experience#setter")
    void setExperience(long r100);

    @FieldName(name = "highest_experience_this_level#setter")
    void setHighestExperienceThisLevel(long r100);

    @FieldName(name = "level#setter")
    void setLevel(int r100);

    @FieldName(name = "small_icon#setter")
    void setLevelIcon(k r100);

    @FieldName(name = "lowest_experience_this_level#setter")
    void setLowestExperienceThisLevel(long r100);

    @FieldName(name = "profile_dialog_bg_back#setter")
    void setProfileDialogBackBg(k r100);

    @FieldName(name = "profile_dialog_bg#setter")
    void setProfileDialogBg(k r100);

    @FieldName(name = "stage_level#setter")
    void setStageLevelIcon(k r100);

    @FieldName(name = "task_decrease_experience#setter")
    void setTaskDecreaseExperience(long r100);

    @FieldName(name = "task_end_time#setter")
    void setTaskEndTime(long r100);

    @FieldName(name = "task_start_experience#setter")
    void setTaskStartExperience(long r100);

    @FieldName(name = "task_start_time#setter")
    void setTaskStartTime(long r100);

    @FieldName(name = "task_target_experience#setter")
    void setTaskTargetExperience(long r100);
}
