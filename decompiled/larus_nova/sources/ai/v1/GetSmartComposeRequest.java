package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class GetSmartComposeRequest extends Message<GetSmartComposeRequest, Builder> {
    public static final ProtoAdapter<GetSmartComposeRequest> ADAPTER = null;
    public static final String DEFAULT_CONTEXT = "";
    public static final String DEFAULT_HIDDEN_STATE = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_PREFIX = "";
    public static final Scene DEFAULT_SCENE = null;
    public static final String DEFAULT_SCENE_INFO = "";
    public static final ProtoAdapter_GetSmartComposeRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String context;
    public final List<ContextItem> context_v2;
    public final String hidden_state;
    public final String locale;
    public final ClientMessengerContext messenger_context;
    public final String prefix;
    public final Scene scene;
    public final String scene_info;

    public static final class Builder extends Message.Builder<GetSmartComposeRequest, Builder> implements d<GetSmartComposeRequest> {
        public String context;
        public List<ContextItem> context_v2;
        public String hidden_state;
        public String locale;
        public ClientMessengerContext messenger_context;
        public String prefix;
        public Scene scene;
        public String scene_info;

        @Override // com.squareup.wire.Message.Builder
        public GetSmartComposeRequest build() {
            Scene r100 = this.scene;
            if (r100 == null) goto L9;
            if (this.prefix == null) goto L9;
            return new GetSmartComposeRequest(this.scene, this.prefix, this.context, this.locale, this.hidden_state, this.scene_info, this.context_v2, this.messenger_context, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "scene", this.prefix, "prefix"});
        }

        public Builder() {
            this.context_v2 = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder context(String r100) {
            this.context = r100;
            return this;
        }

        public Builder context_v2(List<ContextItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.context_v2 = r100;
            return this;
        }

        public Builder hidden_state(String r100) {
            this.hidden_state = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.locale = r100;
            return this;
        }

        public Builder messenger_context(ClientMessengerContext r100) {
            this.messenger_context = r100;
            return this;
        }

        public Builder prefix(String r100) {
            this.prefix = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }

        public Builder scene_info(String r100) {
            this.scene_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSmartComposeRequest extends ProtoAdapter<GetSmartComposeRequest> implements c<GetSmartComposeRequest> {
        public ProtoAdapter_GetSmartComposeRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSmartComposeRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSmartComposeRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene = Scene.UNKNOWN;
            r101.prefix = "";
            r101.context = "";
            r101.locale = "";
            r101.hidden_state = "";
            r101.scene_info = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L20;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.messenger_context = ClientMessengerContext.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.context_v2.add(ContextItem.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.scene_info = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.hidden_state = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.context = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.prefix = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSmartComposeRequest r100) {
            int r101 = Scene.ADAPTER.encodedSizeWithTag(1, r100.scene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(2, r100.prefix);
            String r104 = r100.context;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(3, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.locale;
            if (r108 == null) goto L9;
            int r109 = r102.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            String r111 = r100.hidden_state;
            if (r111 == null) goto L13;
            int r112 = r102.encodedSizeWithTag(5, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.scene_info;
            if (r114 == null) goto L17;
            int r115 = r102.encodedSizeWithTag(6, r114);
        L18:
            int r116 = (r113 + r115) + ContextItem.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.context_v2);
            ClientMessengerContext r117 = r100.messenger_context;
            if (r117 == null) goto L22;
            r105 = ClientMessengerContext.ADAPTER.encodedSizeWithTag(8, r117);
        L22:
            return (r116 + r105) + r100.unknownFields().size();
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSmartComposeRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSmartComposeRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSmartComposeRequest r101) throws IOException {
            Scene.ADAPTER.encodeWithTag(r100, 1, r101.scene);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.prefix);
            String r103 = r101.context;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.locale;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.hidden_state;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.scene_info;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            ContextItem.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.context_v2);
            ClientMessengerContext r107 = r101.messenger_context;
            if (r107 == null) goto L17;
            ClientMessengerContext.ADAPTER.encodeWithTag(r100, 8, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSmartComposeRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene MESSENGER = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("MESSENGER", 1, 1);
            MESSENGER = r101;
            $VALUES = new Scene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return MESSENGER;
        L10:
            return UNKNOWN;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetSmartComposeRequest r100 = new ProtoAdapter_GetSmartComposeRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCENE = Scene.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene = this.scene;
        r100.prefix = this.prefix;
        r100.context = this.context;
        r100.locale = this.locale;
        r100.hidden_state = this.hidden_state;
        r100.scene_info = this.scene_info;
        r100.context_v2 = Internal.copyOf("context_v2", this.context_v2);
        r100.messenger_context = this.messenger_context;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSmartComposeRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSmartComposeRequest(Scene r110, String r111, String r112, String r113, String r114, String r115, List<ContextItem> r116, ClientMessengerContext r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public GetSmartComposeRequest(Scene r100, String r101, String r102, String r103, String r104, String r105, List<ContextItem> r106, ClientMessengerContext r107, ByteString r110) {
        super(ADAPTER, r110);
        this.scene = r100;
        this.prefix = r101;
        this.context = r102;
        this.locale = r103;
        this.hidden_state = r104;
        this.scene_info = r105;
        this.context_v2 = Internal.immutableCopyOf("context_v2", r106);
        this.messenger_context = r107;
    }
}
