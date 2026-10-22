package com.obric.appstore.util;

import androidx.annotation.DrawableRes;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/obric/appstore/util/CategoryIcon;", "", "id", "", "resId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getResId", "()I", "Tools", "Life", "Trip", "Video", "Work", "Education", "Social", "Health", "Money", "Read", "Music", "System", "Beautiful", "Shop", "Photography", "Travel", "Relaxation", "Role", "Action", "Sports", "Military", "Chess", "Strategy", NetKey.NETWORK, "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CategoryIcon extends Enum<CategoryIcon> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CategoryIcon[] $VALUES = null;
    public static final CategoryIcon Action = null;
    public static final CategoryIcon Beautiful = null;
    public static final CategoryIcon Chess = null;
    public static final CategoryIcon Education = null;
    public static final CategoryIcon Health = null;
    public static final CategoryIcon Life = null;
    public static final CategoryIcon Military = null;
    public static final CategoryIcon Money = null;
    public static final CategoryIcon Music = null;
    public static final CategoryIcon Network = null;
    public static final CategoryIcon Photography = null;
    public static final CategoryIcon Read = null;
    public static final CategoryIcon Relaxation = null;
    public static final CategoryIcon Role = null;
    public static final CategoryIcon Shop = null;
    public static final CategoryIcon Social = null;
    public static final CategoryIcon Sports = null;
    public static final CategoryIcon Strategy = null;
    public static final CategoryIcon System = null;
    public static final CategoryIcon Tools = null;
    public static final CategoryIcon Travel = null;
    public static final CategoryIcon Trip = null;
    public static final CategoryIcon Video = null;
    public static final CategoryIcon Work = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f11054id;
    private final int resId;

    private static final /* synthetic */ CategoryIcon[] $values() {
        return new CategoryIcon[]{Tools, Life, Trip, Video, Work, Education, Social, Health, Money, Read, Music, System, Beautiful, Shop, Photography, Travel, Relaxation, Role, Action, Sports, Military, Chess, Strategy, Network};
    }

    static {
        pa.a r10 = pa.a.f23414a;
        String r11 = r10.a().getString(R.string.category_tools);
        kotlin.jvm.internal.q.f(r11, "getString(...)");
        Tools = new CategoryIcon("Tools", 0, r11, R.drawable.category_tools);
        String r12 = r10.a().getString(R.string.category_life);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
        Life = new CategoryIcon("Life", 1, r12, R.drawable.category_life);
        String r13 = r10.a().getString(R.string.category_trip);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        Trip = new CategoryIcon("Trip", 2, r13, R.drawable.category_trip);
        String r14 = r10.a().getString(R.string.category_video);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        Video = new CategoryIcon("Video", 3, r14, R.drawable.category_video);
        String r15 = r10.a().getString(R.string.category_work);
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        Work = new CategoryIcon("Work", 4, r15, R.drawable.category_work);
        String r16 = r10.a().getString(R.string.category_education);
        kotlin.jvm.internal.q.f(r16, "getString(...)");
        Education = new CategoryIcon("Education", 5, r16, R.drawable.category_education);
        String r17 = r10.a().getString(R.string.category_social);
        kotlin.jvm.internal.q.f(r17, "getString(...)");
        Social = new CategoryIcon("Social", 6, r17, R.drawable.category_social);
        String r18 = r10.a().getString(R.string.category_health);
        kotlin.jvm.internal.q.f(r18, "getString(...)");
        Health = new CategoryIcon("Health", 7, r18, R.drawable.category_health);
        String r19 = r10.a().getString(R.string.category_money);
        kotlin.jvm.internal.q.f(r19, "getString(...)");
        Money = new CategoryIcon("Money", 8, r19, R.drawable.category_money);
        String r20 = r10.a().getString(R.string.category_read);
        kotlin.jvm.internal.q.f(r20, "getString(...)");
        Read = new CategoryIcon("Read", 9, r20, R.drawable.category_read);
        String r21 = r10.a().getString(R.string.category_music);
        kotlin.jvm.internal.q.f(r21, "getString(...)");
        Music = new CategoryIcon("Music", 10, r21, R.drawable.category_music);
        String r22 = r10.a().getString(R.string.category_system);
        kotlin.jvm.internal.q.f(r22, "getString(...)");
        System = new CategoryIcon("System", 11, r22, R.drawable.category_system);
        String r23 = r10.a().getString(R.string.category_beautiful);
        kotlin.jvm.internal.q.f(r23, "getString(...)");
        Beautiful = new CategoryIcon("Beautiful", 12, r23, R.drawable.category_beautiful);
        String r24 = r10.a().getString(R.string.category_shop);
        kotlin.jvm.internal.q.f(r24, "getString(...)");
        Shop = new CategoryIcon("Shop", 13, r24, R.drawable.category_shop);
        String r25 = r10.a().getString(R.string.category_photography);
        kotlin.jvm.internal.q.f(r25, "getString(...)");
        Photography = new CategoryIcon("Photography", 14, r25, R.drawable.category_photography);
        String r26 = r10.a().getString(R.string.category_travel);
        kotlin.jvm.internal.q.f(r26, "getString(...)");
        Travel = new CategoryIcon("Travel", 15, r26, R.drawable.category_travel);
        String r27 = r10.a().getString(R.string.category_relaxation);
        kotlin.jvm.internal.q.f(r27, "getString(...)");
        Relaxation = new CategoryIcon("Relaxation", 16, r27, R.drawable.category_relaxation);
        String r28 = r10.a().getString(R.string.category_role);
        kotlin.jvm.internal.q.f(r28, "getString(...)");
        Role = new CategoryIcon("Role", 17, r28, R.drawable.category_role);
        String r29 = r10.a().getString(R.string.category_action);
        kotlin.jvm.internal.q.f(r29, "getString(...)");
        Action = new CategoryIcon("Action", 18, r29, R.drawable.category_action);
        String r30 = r10.a().getString(R.string.category_sports);
        kotlin.jvm.internal.q.f(r30, "getString(...)");
        Sports = new CategoryIcon("Sports", 19, r30, R.drawable.category_sports);
        String r31 = r10.a().getString(R.string.category_military);
        kotlin.jvm.internal.q.f(r31, "getString(...)");
        Military = new CategoryIcon("Military", 20, r31, R.drawable.category_military);
        String r32 = r10.a().getString(R.string.category_chess);
        kotlin.jvm.internal.q.f(r32, "getString(...)");
        Chess = new CategoryIcon("Chess", 21, r32, R.drawable.category_chess);
        String r33 = r10.a().getString(R.string.category_strategy);
        kotlin.jvm.internal.q.f(r33, "getString(...)");
        Strategy = new CategoryIcon("Strategy", 22, r33, R.drawable.category_strategy);
        String r34 = r10.a().getString(R.string.category_network);
        kotlin.jvm.internal.q.f(r34, "getString(...)");
        Network = new CategoryIcon(NetKey.NETWORK, 23, r34, R.drawable.category_network);
        CategoryIcon[] r35 = $values();
        $VALUES = r35;
        $ENTRIES = kotlin.enums.a.a(r35);
    }

    private CategoryIcon(String r10, @DrawableRes int r11, String r12, int r13) {
        super(r10, r11);
        this.f11054id = r12;
        this.resId = r13;
    }

    @NotNull
    public static EnumEntries<CategoryIcon> getEntries() {
        return $ENTRIES;
    }

    public static CategoryIcon valueOf(String r10) {
        return (CategoryIcon) Enum.valueOf(CategoryIcon.class, r10);
    }

    public static CategoryIcon[] values() {
        return (CategoryIcon[]) $VALUES.clone();
    }

    @NotNull
    public final String getId() {
        return this.f11054id;
    }

    public final int getResId() {
        return this.resId;
    }
}
