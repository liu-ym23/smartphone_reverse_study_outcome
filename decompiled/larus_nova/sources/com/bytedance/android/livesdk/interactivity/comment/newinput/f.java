package com.bytedance.android.livesdk.interactivity.comment.newinput;

import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f135425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f135426b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f135427c = null;

    static {
        int[] r100 = new int[InputDialogFragmentSwitchType.values().length];
        f135425a = r100;
        InputDialogFragmentSwitchType r101 = InputDialogFragmentSwitchType.SLIDE_RIGHT;
        r100[r101.ordinal()] = 1;
        InputDialogFragmentSwitchType r102 = InputDialogFragmentSwitchType.NONE;
        r100[r102.ordinal()] = 2;
        InputDialogFragmentSwitchType r103 = InputDialogFragmentSwitchType.FADE;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[InputDialogFragmentSwitchType.values().length];
        f135426b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[InputSectionType.values().length];
        f135427c = r105;
        r105[InputSectionType.DANMAKU.ordinal()] = 1;
        r105[InputSectionType.WORD_ASSOCIATE.ordinal()] = 2;
        r105[InputSectionType.MENTION.ordinal()] = 3;
    }
}
