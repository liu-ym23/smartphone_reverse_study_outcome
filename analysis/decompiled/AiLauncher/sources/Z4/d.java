package Z4;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.blankj.utilcode.util.m;
import com.stepos.ailauncher.agent.R$dimen;
import com.stepos.ailauncher.agent.R$drawable;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.chat.AgentChatActivity;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006#"}, d2 = {"LZ4/d;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LZ4/e;", "task", "LY8/t;", Const.INTENT_KEY_UMID, "(LZ4/e;)V", "", "taskId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "f", "(Landroid/view/View;LZ4/e;)V", "Landroid/widget/ImageView;", "avatarIcon", "Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "taskContainer", "Landroid/widget/LinearLayout;", "", "taskViews", "Ljava/util/Map;", "tasks", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends FrameLayout {
    private static final int MAX_TASK_ICONS = 2;
    private static final String TAG = "DynamicIsland";
    private final ImageView avatarIcon;
    private final LinearLayout taskContainer;
    private final Map<String, ImageView> taskViews;
    private final Map<String, TaskIconInfo> tasks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.taskViews = new LinkedHashMap();
        this.tasks = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R$layout.view_dynamic_island, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R$id.iv_avatar);
        p.h(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        this.avatarIcon = imageView;
        View viewFindViewById2 = findViewById(R$id.task_container);
        p.h(viewFindViewById2, "findViewById(...)");
        this.taskContainer = (LinearLayout) viewFindViewById2;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: Z4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.c(context, view);
            }
        });
    }

    public static final void c(Context context, View view) {
        C4148a.d(TAG, "Avatar clicked", false, 4, null);
        AgentChatActivity.INSTANCE.a(context);
    }

    public static final void e(d dVar, TaskIconInfo taskIconInfo, View view) {
        p.f(view);
        dVar.f(view, taskIconInfo);
    }

    public final void d(final TaskIconInfo task) {
        p.i(task, "task");
        if (this.taskViews.size() >= 2) {
            y yVar = y.f34840a;
            String str = String.format("Max task icons reached, ignoring: %s", Arrays.copyOf(new Object[]{task.getTaskId()}, 1));
            p.h(str, "format(...)");
            C4148a.u(TAG, str, false, 4, null);
            return;
        }
        if (this.taskViews.containsKey(task.getTaskId())) {
            y yVar2 = y.f34840a;
            String str2 = String.format("Task already shown: %s", Arrays.copyOf(new Object[]{task.getTaskId()}, 1));
            p.h(str2, "format(...)");
            C4148a.d(TAG, str2, false, 4, null);
            return;
        }
        ImageView imageView = new ImageView(getContext());
        Resources resources = imageView.getResources();
        int i10 = R$dimen.island_icon_size;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(resources.getDimensionPixelSize(i10), imageView.getResources().getDimensionPixelSize(i10));
        layoutParams.setMarginStart(imageView.getResources().getDimensionPixelSize(R$dimen.island_icon_spacing));
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R$drawable.bg_island_icon);
        int iA = m.a(4.0f);
        imageView.setPadding(iA, iA, iA, iA);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(task.getIconRes());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: Z4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(this.f7292a, task, view);
            }
        });
        this.tasks.put(task.getTaskId(), task);
        this.taskViews.put(task.getTaskId(), imageView);
        this.taskContainer.addView(imageView);
        y yVar3 = y.f34840a;
        String str3 = String.format("Task icon added: %s, total: %d", Arrays.copyOf(new Object[]{task.getTaskId(), Integer.valueOf(this.taskViews.size())}, 2));
        p.h(str3, "format(...)");
        C4148a.d(TAG, str3, false, 4, null);
    }

    public final void f(View anchor, TaskIconInfo task) {
        y yVar = y.f34840a;
        String str = String.format("Task icon clicked: %s", Arrays.copyOf(new Object[]{task.getTaskId()}, 1));
        p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        Context context = getContext();
        p.h(context, "getContext(...)");
        new f(context).a(anchor, task);
    }

    public final void g(String taskId) {
        TaskIconInfo taskIconInfo;
        p.i(taskId, "taskId");
        ImageView imageView = this.taskViews.get(taskId);
        if (imageView == null || (taskIconInfo = this.tasks.get(taskId)) == null) {
            return;
        }
        f(imageView, taskIconInfo);
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
