package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bA\u0010BR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010$\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R6\u00101\u001a\u0016\u0012\u0004\u0012\u00020/\u0018\u00010.j\n\u0012\u0004\u0012\u00020/\u0018\u0001`08\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020>\u0018\u0001078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u00109\u001a\u0004\b@\u0010;¨\u0006E"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListSectionDTO;", "Ljava/io/Serializable;", "", "sectionId", "Ljava/lang/String;", "getSectionId", "()Ljava/lang/String;", "setSectionId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/ECSectionOperationType;", "operationType", "Lcom/bytedance/android/ec/hybrid/list/entity/ECSectionOperationType;", "getOperationType", "()Lcom/bytedance/android/ec/hybrid/list/entity/ECSectionOperationType;", "setOperationType", "(Lcom/bytedance/android/ec/hybrid/list/entity/ECSectionOperationType;)V", "", "operationAnimated", "Z", "getOperationAnimated", "()Z", "setOperationAnimated", "(Z)V", "", "operationScrollLocation", "I", "getOperationScrollLocation", "()I", "setOperationScrollLocation", "(I)V", "operationScrollLocationDelay", "getOperationScrollLocationDelay", "setOperationScrollLocationDelay", "layoutColumn", "getLayoutColumn", "setLayoutColumn", "type", "getType", "setType", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "sectionStyle", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "getSectionStyle", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "setSectionStyle", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemDTO;", "Lkotlin/collections/ArrayList;", "items", "Ljava/util/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "", "abValues", "getAbValues", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListSectionDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("ab_values")
    private final Map<String, Object> abValues;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("items")
    private ArrayList<ECHybridListItemDTO> items;

    @SerializedName("layout_column")
    private int layoutColumn;

    @SerializedName("operation_animated")
    private boolean operationAnimated;

    @SerializedName("operation_scroll_location")
    private int operationScrollLocation;

    @SerializedName("operation_scroll_location_delay")
    private int operationScrollLocationDelay;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE)
    private ECSectionOperationType operationType;

    @SerializedName("section_id")
    private String sectionId;

    @SerializedName("section_style")
    private ECHybridListStyleDTO sectionStyle;

    @SerializedName("type")
    private int type;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO$a$a, reason: collision with other inner class name */
        public static final class RunnableC0823a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f47084a;

            public RunnableC0823a(i r100) {
                this.f47084a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<ECHybridListItemVO> r100 = this.f47084a.f47115i;     // Catch: Throwable -> L9
                if (r100 == null) goto L12;
                ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));     // Catch: Throwable -> L9
                Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L9
            L6:
                if (r102.hasNext() == false) goto L19;
                r101.add(((ECHybridListItemVO) r102.next()).b());     // Catch: Throwable -> L9
                goto L6
            L19:
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L18;
                throw th;
            }
        }

        public a() {
        }

        public static i a(ECHybridListSectionDTO r110, boolean r111, com.bytedance.android.ec.hybrid.list.entity.dto.a r210) {
            if (r110 == null) goto L5;
            i r100 = new i();
            r100.f47107a = r110.getSectionId();
            ECSectionOperationType r101 = r110.getOperationType();
            if (r101 == null) goto L9;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f47108b = r101;
        L9:
            r100.f47109c = Boolean.valueOf(r110.getOperationAnimated());
            r100.f47110d = Integer.valueOf(r110.getOperationScrollLocation());
            r100.f47111e = Integer.valueOf(r110.getOperationScrollLocationDelay());
            r100.f47112f = r110.getLayoutColumn();
            r100.f47113g = r110.getType();
            ECHybridListStyleDTO.a r102 = ECHybridListStyleDTO.Companion;
            ECHybridListStyleDTO r103 = r110.getSectionStyle();
            r102.getClass();
            r100.f47114h = ECHybridListStyleDTO.a.a(r103);
            ArrayList<ECHybridListItemDTO> r104 = r110.getItems();
            if (r104 == null) goto L27;
            ArrayList<ECHybridListItemVO> r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator<T> r106 = r104.iterator();
            int r107 = 0;
        L13:
            if (r106.hasNext() == false) goto L26;
            Object r108 = r106.next();
            int r112 = r107 + 1;
            if (r107 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            ECHybridListItemDTO r109 = (ECHybridListItemDTO) r108;
            ECHybridListItemDTO.Companion r113 = ECHybridListItemDTO.Companion;
            String r114 = r100.f47107a;
            if (r210 == 0) goto L24;
            ArrayList<ECHybridListItemDTO> r115 = r110.getItems();
            if (r115 == null) goto L22;
            int r116 = r115.size();
        L23:
            Map<String, Object> r117 = r110.getAbValues();
            int r118 = r210.f47086a;
            String r119 = r210.f47089d;
            Map<String, ? extends Object> r120 = r210.f47091f;
            String r121 = r210.f47092g;
            Integer r122 = r210.f47093h;
            Intrinsics.checkNotNullParameter(r119, "sessionId");
            com.bytedance.android.ec.hybrid.list.entity.dto.a r123 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(r118, r107, r116, r119, r117, r120, r121, r122);
        L25:
            r113.getClass();
            r105.add(ECHybridListItemDTO.Companion.b(r109, r114, r111, r123));
            r107 = r112;
            goto L13
        L22:
            r116 = -1;
            goto L23
        L24:
            r123 = null;
            goto L25
        L26:
            ArrayList<ECHybridListItemVO> r124 = r105;
        L28:
            r100.f47115i = r124;
            r100.f47116j = r110.getExtra();
            com.bytedance.android.ec.hybrid.a.d().submit(new RunnableC0823a(r100));
            return r100;
        L27:
            r124 = null;
            goto L28
        L5:
            return new i();
        }
    }

    static {
        Companion = new a();
    }

    public ECHybridListSectionDTO() {
    }

    public final Map<String, Object> getAbValues() {
        return this.abValues;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final ArrayList<ECHybridListItemDTO> getItems() {
        return this.items;
    }

    public final int getLayoutColumn() {
        return this.layoutColumn;
    }

    public final boolean getOperationAnimated() {
        return this.operationAnimated;
    }

    public final int getOperationScrollLocation() {
        return this.operationScrollLocation;
    }

    public final int getOperationScrollLocationDelay() {
        return this.operationScrollLocationDelay;
    }

    public final ECSectionOperationType getOperationType() {
        return this.operationType;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final ECHybridListStyleDTO getSectionStyle() {
        return this.sectionStyle;
    }

    public final int getType() {
        return this.type;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setItems(ArrayList<ECHybridListItemDTO> r100) {
        this.items = r100;
    }

    public final void setLayoutColumn(int r100) {
        this.layoutColumn = r100;
    }

    public final void setOperationAnimated(boolean r100) {
        this.operationAnimated = r100;
    }

    public final void setOperationScrollLocation(int r100) {
        this.operationScrollLocation = r100;
    }

    public final void setOperationScrollLocationDelay(int r100) {
        this.operationScrollLocationDelay = r100;
    }

    public final void setOperationType(ECSectionOperationType r100) {
        this.operationType = r100;
    }

    public final void setSectionId(String r100) {
        this.sectionId = r100;
    }

    public final void setSectionStyle(ECHybridListStyleDTO r100) {
        this.sectionStyle = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
