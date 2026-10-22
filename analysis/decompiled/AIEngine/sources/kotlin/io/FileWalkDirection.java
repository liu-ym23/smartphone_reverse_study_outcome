package kotlin.io;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FileWalkDirection {

    /* renamed from: a, reason: collision with root package name */
    public static final FileWalkDirection f10069a;

    /* renamed from: b, reason: collision with root package name */
    public static final FileWalkDirection f10070b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ FileWalkDirection[] f10071c;

    static {
        FileWalkDirection fileWalkDirection = new FileWalkDirection("TOP_DOWN", 0);
        f10069a = fileWalkDirection;
        FileWalkDirection fileWalkDirection2 = new FileWalkDirection("BOTTOM_UP", 1);
        f10070b = fileWalkDirection2;
        FileWalkDirection[] fileWalkDirectionArr = {fileWalkDirection, fileWalkDirection2};
        f10071c = fileWalkDirectionArr;
        a.a(fileWalkDirectionArr);
    }

    public FileWalkDirection() {
        throw null;
    }

    public static FileWalkDirection valueOf(String str) {
        return (FileWalkDirection) Enum.valueOf(FileWalkDirection.class, str);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[]) f10071c.clone();
    }
}
