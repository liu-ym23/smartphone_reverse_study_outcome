package f1;

import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil__DBUtil_androidKt;
import e9.InterfaceC4014c;
import i1.InterfaceC4160b;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"f1/b", "androidx/room/util/DBUtil__DBUtil_androidKt"}, d2 = {}, k = 4, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4031a {
    public static final void a(InterfaceC4160b interfaceC4160b) {
        C4032b.a(interfaceC4160b);
    }

    public static final Object b(RoomDatabase roomDatabase, boolean z10, InterfaceC4014c<? super kotlin.coroutines.d> interfaceC4014c) {
        return DBUtil__DBUtil_androidKt.a(roomDatabase, z10, interfaceC4014c);
    }

    public static final <R> R c(RoomDatabase roomDatabase, boolean z10, boolean z11, InterfaceC5074l<? super InterfaceC4160b, ? extends R> interfaceC5074l) {
        return (R) DBUtil__DBUtil_androidKt.b(roomDatabase, z10, z11, interfaceC5074l);
    }

    public static final <R> Object d(RoomDatabase roomDatabase, InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
        return DBUtil__DBUtil_androidKt.c(roomDatabase, interfaceC5074l, interfaceC4014c);
    }

    public static final <R> Object e(RoomDatabase roomDatabase, boolean z10, boolean z11, InterfaceC5074l<? super InterfaceC4160b, ? extends R> interfaceC5074l, InterfaceC4014c<? super R> interfaceC4014c) {
        return DBUtil__DBUtil_androidKt.d(roomDatabase, z10, z11, interfaceC5074l, interfaceC4014c);
    }

    public static final int f(File file) throws IOException {
        return DBUtil__DBUtil_androidKt.e(file);
    }
}
