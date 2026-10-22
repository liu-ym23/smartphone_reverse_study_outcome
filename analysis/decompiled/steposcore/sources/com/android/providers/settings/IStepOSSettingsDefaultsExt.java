package com.android.providers.settings;

import android.database.sqlite.SQLiteDatabase;
import com.stepos.framework.annotations.StepOSStubHead;
import com.stepos.framework.utils.StepOSFrameworkStubUtils;

@StepOSStubHead(manifestName = "com.stepos.framework.impl.StepOSFrameworkStubImplMap_Framework")
/* loaded from: classes.dex */
public interface IStepOSSettingsDefaultsExt {
    void loadGlobalDefaults(SQLiteDatabase sQLiteDatabase, int i);

    void loadSecureDefaults(SQLiteDatabase sQLiteDatabase, int i);

    void loadSystemDefaults(SQLiteDatabase sQLiteDatabase, int i);

    static IStepOSSettingsDefaultsExt get() {
        return (IStepOSSettingsDefaultsExt) StepOSFrameworkStubUtils.getInstance(IStepOSSettingsDefaultsExt.class);
    }
}
