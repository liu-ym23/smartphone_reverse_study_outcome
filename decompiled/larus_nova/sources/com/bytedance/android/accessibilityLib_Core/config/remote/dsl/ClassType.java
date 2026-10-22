package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import com.vivo.push.PushClientConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/ClassType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Lkotlin/Lazy;", PushClientConstants.TAG_CLASS_NAME, "Lkotlin/Lazy;", "getClassName", "()Lkotlin/Lazy;", "Default", "Button", "EditText", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum ClassType extends Enum<ClassType> {
    public static final ClassType Button = null;
    public static final ClassType Default = null;
    public static final ClassType EditText = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClassType[] f38173a = null;
    private final Lazy<String> className;
    private final String value;

    static {
        ClassType r100 = new ClassType("Default", 0, "default", LazyKt.lazy(AnonymousClass1.INSTANCE));
        Default = r100;
        ClassType r101 = new ClassType("Button", 1, "button", LazyKt.lazy(AnonymousClass2.INSTANCE));
        Button = r101;
        ClassType r102 = new ClassType("EditText", 2, "edittext", LazyKt.lazy(AnonymousClass3.INSTANCE));
        EditText = r102;
        f38173a = new ClassType[]{r100, r101, r102};
    }

    public static ClassType valueOf(String r100) {
        return (ClassType) r27.a.a(ClassType.class, r100);
    }

    public static ClassType[] values() {
        return (ClassType[]) f38173a.clone();
    }

    public final Lazy<String> getClassName() {
        return this.className;
    }

    public final String getValue() {
        return this.value;
    }

    public ClassType(String r100, int r101, String r102, Lazy r103) {
        super(r100, r101);
        this.value = r102;
        this.className = r103;
    }
}
