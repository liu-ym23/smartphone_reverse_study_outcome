package com.bytedance.android.live.liveinteract.api.fulllink;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/live/liveinteract/api/fulllink/CommonWindowLayoutConfigException$ExceptionType", "", "Lcom/bytedance/android/live/liveinteract/api/fulllink/CommonWindowLayoutConfigException$ExceptionType;", "REVIEW_LIST_EXCEPTION", "REVIEW_LIST_EMPTY", "REVIEW_LIST_LOAD_SUCCESS", "LAYOUT_CONFIG_NOT_FOUND", "LAYOUT_CONFIG_EXCEPTION", "LAYOUT_CONFIG_LOAD_SUCCESS", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CommonWindowLayoutConfigException$ExceptionType extends Enum<CommonWindowLayoutConfigException$ExceptionType> {
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_EXCEPTION = null;
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_LOAD_SUCCESS = null;
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_NOT_FOUND = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_EMPTY = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_EXCEPTION = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_LOAD_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonWindowLayoutConfigException$ExceptionType[] f71445a = null;

    static {
        CommonWindowLayoutConfigException$ExceptionType r100 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_EXCEPTION", 0);
        REVIEW_LIST_EXCEPTION = r100;
        CommonWindowLayoutConfigException$ExceptionType r101 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_EMPTY", 1);
        REVIEW_LIST_EMPTY = r101;
        CommonWindowLayoutConfigException$ExceptionType r102 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_LOAD_SUCCESS", 2);
        REVIEW_LIST_LOAD_SUCCESS = r102;
        CommonWindowLayoutConfigException$ExceptionType r103 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_NOT_FOUND", 3);
        LAYOUT_CONFIG_NOT_FOUND = r103;
        CommonWindowLayoutConfigException$ExceptionType r104 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_EXCEPTION", 4);
        LAYOUT_CONFIG_EXCEPTION = r104;
        CommonWindowLayoutConfigException$ExceptionType r105 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_LOAD_SUCCESS", 5);
        LAYOUT_CONFIG_LOAD_SUCCESS = r105;
        f71445a = new CommonWindowLayoutConfigException$ExceptionType[]{r100, r101, r102, r103, r104, r105};
    }

    public static CommonWindowLayoutConfigException$ExceptionType valueOf(String r100) {
        return (CommonWindowLayoutConfigException$ExceptionType) a.a(CommonWindowLayoutConfigException$ExceptionType.class, r100);
    }

    public static CommonWindowLayoutConfigException$ExceptionType[] values() {
        return (CommonWindowLayoutConfigException$ExceptionType[]) f71445a.clone();
    }

    public CommonWindowLayoutConfigException$ExceptionType(String r100, int r101) {
        super(r100, r101);
    }
}
