package androidx.sqlite;

import androidx.annotation.IntRange;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\n\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J!\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00102\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00182\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b+\u0010(J\u000f\u0010,\u001a\u00020\u0003H&¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u00182\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b.\u0010*J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180/H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b2\u0010&J\u000f\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0007H&¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0007H&¢\u0006\u0004\b7\u00106J\u000f\u00108\u001a\u00020\u0007H&¢\u0006\u0004\b8\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00069À\u0006\u0001"}, d2 = {"Landroidx/sqlite/SQLiteStatement;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindFloat", "(IF)V", "", "bindLong", "(IJ)V", "bindInt", "(II)V", "", "bindBoolean", "(IZ)V", "", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getFloat", "(I)F", "getLong", "(I)J", "getInt", "(I)I", "getBoolean", "(I)Z", "getText", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "", "getColumnNames", "()Ljava/util/List;", "getColumnType", "step", "()Z", "reset", "()V", "clearBindings", "close", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SQLiteStatement extends AutoCloseable {
    /* renamed from: bindBlob */
    void mo7168bindBlob(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, byte[] value);

    default void bindBoolean(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, boolean value) {
        mo7170bindLong(index, value ? 1L : 0L);
    }

    /* renamed from: bindDouble */
    void mo7169bindDouble(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, double value);

    default void bindFloat(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, float value) {
        mo7169bindDouble(index, value);
    }

    default void bindInt(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, int value) {
        mo7170bindLong(index, value);
    }

    /* renamed from: bindLong */
    void mo7170bindLong(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, long value);

    /* renamed from: bindNull */
    void mo7171bindNull(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index);

    /* renamed from: bindText */
    void mo7172bindText(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, String value);

    /* renamed from: clearBindings */
    void mo7173clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    byte[] getBlob(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    default boolean getBoolean(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return getLong(index) != 0;
    }

    int getColumnCount();

    String getColumnName(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    default List<String> getColumnNames() {
        int columnCount = getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(getColumnName(i));
        }
        return arrayList;
    }

    int getColumnType(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    double getDouble(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    default float getFloat(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return (float) getDouble(index);
    }

    default int getInt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return (int) getLong(index);
    }

    long getLong(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    String getText(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    boolean isNull(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index);

    void reset();

    boolean step();
}
