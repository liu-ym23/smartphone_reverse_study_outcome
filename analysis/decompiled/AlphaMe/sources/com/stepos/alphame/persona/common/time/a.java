package com.stepos.alphame.persona.common.time;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PersonalCommonTimePickerActivity f11203b;

    public /* synthetic */ a(PersonalCommonTimePickerActivity personalCommonTimePickerActivity, int i4) {
        this.f11202a = i4;
        this.f11203b = personalCommonTimePickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f11202a;
        PersonalCommonTimePickerActivity personalCommonTimePickerActivity = this.f11203b;
        switch (i4) {
            case 0:
                PersonalCommonTimePickerActivity.initCustomView$lambda$12$lambda$11(personalCommonTimePickerActivity, view);
                break;
            case 1:
                PersonalCommonTimePickerActivity.setToolbar$lambda$2$lambda$0(personalCommonTimePickerActivity, view);
                break;
            case 2:
                PersonalCommonTimePickerActivity.setToolbar$lambda$2$lambda$1(personalCommonTimePickerActivity, view);
                break;
            default:
                PersonalCommonTimePickerActivity.initAutoLearningView$lambda$7$lambda$6(personalCommonTimePickerActivity, view);
                break;
        }
    }
}
