package stepos.com.android.os;

import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface StateAtomFieldOptionOrBuilder extends MessageLiteOrBuilder {
    int getDefaultStateValue();

    boolean getExclusiveState();

    boolean getNested();

    boolean getPrimaryField();

    boolean getPrimaryFieldFirstUid();

    int getTriggerStateResetValue();

    boolean hasDefaultStateValue();

    boolean hasExclusiveState();

    boolean hasNested();

    boolean hasPrimaryField();

    boolean hasPrimaryFieldFirstUid();

    boolean hasTriggerStateResetValue();
}
