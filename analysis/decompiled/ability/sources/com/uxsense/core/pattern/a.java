package com.uxsense.core.pattern;

import com.uxsense.core.pattern.ViewPattern;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4202a;

    public /* synthetic */ a(int i) {
        this.f4202a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4202a) {
            case 0:
                return ViewPattern.NodePatternSurrogate._childSerializers$_anonymous_();
            case 1:
                return ViewPattern.NodePatternSurrogate._childSerializers$_anonymous_$0();
            case 2:
                return ViewPattern.NodePatternSurrogate._childSerializers$_anonymous_$1();
            case 3:
                return NodeCondition._childSerializers$_anonymous_();
            case 4:
                return ValueSource._init_$_anonymous_();
            case 5:
                return ViewPattern._init_$_anonymous_();
            case 6:
                return ViewPattern.AnyOf._childSerializers$_anonymous_();
            case 7:
                return ViewPattern.Branches._childSerializers$_anonymous_();
            case 8:
                return ViewPattern.Branches.Branch._childSerializers$_anonymous_();
            case 9:
                return ViewPattern.ConditionalGroup._childSerializers$_anonymous_();
            default:
                return ViewPattern.NoneOf._childSerializers$_anonymous_();
        }
    }
}
