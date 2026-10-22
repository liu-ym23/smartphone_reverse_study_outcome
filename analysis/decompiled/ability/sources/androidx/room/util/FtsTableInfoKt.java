package androidx.room.util;

import D7.v;
import j9.n;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"equalsCommon", "", "Landroidx/room/util/FtsTableInfo;", "other", "", "hashCodeCommon", "", "toStringCommon", "", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FtsTableInfoKt {
    public static final boolean equalsCommon(FtsTableInfo ftsTableInfo, Object obj) {
        k.f(ftsTableInfo, "<this>");
        if (ftsTableInfo == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo2 = (FtsTableInfo) obj;
        if (k.b(ftsTableInfo.name, ftsTableInfo2.name) && k.b(ftsTableInfo.columns, ftsTableInfo2.columns)) {
            return k.b(ftsTableInfo.options, ftsTableInfo2.options);
        }
        return false;
    }

    public static final int hashCodeCommon(FtsTableInfo ftsTableInfo) {
        k.f(ftsTableInfo, "<this>");
        return ftsTableInfo.options.hashCode() + ((ftsTableInfo.columns.hashCode() + (ftsTableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(FtsTableInfo ftsTableInfo) {
        k.f(ftsTableInfo, "<this>");
        return n.S("\n            |FtsTableInfo {\n            |   name = '" + ftsTableInfo.name + "',\n            |   columns = {" + TableInfoKt.formatString(v.Y0(ftsTableInfo.columns)) + "\n            |   options = {" + TableInfoKt.formatString(v.Y0(ftsTableInfo.options)) + "\n            |}\n        ");
    }
}
