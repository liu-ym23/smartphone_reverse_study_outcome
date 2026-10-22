package androidx.room;

import k0.InterfaceC0674b;
import kotlin.Deprecated;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class B {

    @JvmField
    public final int version;

    public B(int i4) {
        this.version = i4;
    }

    public abstract void createAllTables(InterfaceC0674b interfaceC0674b);

    public abstract void dropAllTables(InterfaceC0674b interfaceC0674b);

    public abstract void onCreate(InterfaceC0674b interfaceC0674b);

    public abstract void onOpen(InterfaceC0674b interfaceC0674b);

    public abstract void onPostMigrate(InterfaceC0674b interfaceC0674b);

    public abstract void onPreMigrate(InterfaceC0674b interfaceC0674b);

    public abstract C onValidateSchema(InterfaceC0674b interfaceC0674b);

    @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
    public void validateMigration(@NotNull InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        throw new UnsupportedOperationException("validateMigration is deprecated");
    }
}
