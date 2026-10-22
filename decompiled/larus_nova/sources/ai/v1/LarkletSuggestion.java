package ai.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
public final class LarkletSuggestion extends Message<LarkletSuggestion, Builder> {
    public static final ProtoAdapter<LarkletSuggestion> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final Double DEFAULT_CONFIDENCE = null;
    public static final String DEFAULT_LARKLET_NAME = "";
    private static final long serialVersionUID = 0;
    public final Action action;
    public final Double confidence;
    public final String larklet_name;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action DESTROY = null;
        public static final Action LOAD = null;
        private final int value;

        static {
            Action r100 = new Action("LOAD", 0, 0);
            LOAD = r100;
            Action r101 = new Action("DESTROY", 1, 1);
            DESTROY = r101;
            $VALUES = new Action[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DESTROY;
        L10:
            return LOAD;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<LarkletSuggestion, Builder> {
        public Action action;
        public Double confidence;
        public String larklet_name;

        @Override // com.squareup.wire.Message.Builder
        public LarkletSuggestion build() {
            String r100 = this.larklet_name;
            if (r100 == null) goto L9;
            if (this.action == null) goto L9;
            return new LarkletSuggestion(this.larklet_name, this.action, this.confidence, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "larklet_name", this.action, "action"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder confidence(Double r100) {
            this.confidence = r100;
            return this;
        }

        public Builder larklet_name(String r100) {
            this.larklet_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkletSuggestion extends ProtoAdapter<LarkletSuggestion> {
        public ProtoAdapter_LarkletSuggestion() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkletSuggestion.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkletSuggestion decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.larklet_name = "";
            r101.action = Action.LOAD;
            r101.confidence = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.larklet_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.confidence = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkletSuggestion r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.larklet_name) + Action.ADAPTER.encodedSizeWithTag(2, r100.action);
            Double r102 = r100.confidence;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkletSuggestion decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkletSuggestion r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkletSuggestion r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.larklet_name);
            Action.ADAPTER.encodeWithTag(r100, 2, r101.action);
            Double r102 = r101.confidence;
            if (r102 == null) goto L5;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkletSuggestion r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkletSuggestion();
        DEFAULT_ACTION = Action.LOAD;
        DEFAULT_CONFIDENCE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.larklet_name = this.larklet_name;
        r100.action = this.action;
        r100.confidence = this.confidence;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkletSuggestion.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkletSuggestion(String r100, Action r101, Double r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LarkletSuggestion(String r100, Action r101, Double r102, ByteString r103) {
        super(ADAPTER, r103);
        this.larklet_name = r100;
        this.action = r101;
        this.confidence = r102;
    }
}
