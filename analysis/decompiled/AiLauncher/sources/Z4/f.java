package Z4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"LZ4/f;", "Landroid/widget/PopupWindow;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "LZ4/e;", "task", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;LZ4/e;)V", "contentView", "Landroid/view/View;", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "tvDesc", "tvStatus", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f extends PopupWindow {
    private final View contentView;
    private final TextView tvDesc;
    private final TextView tvStatus;
    private final TextView tvTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context);
        p.i(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.popup_task_card, (ViewGroup) null);
        p.h(viewInflate, "inflate(...)");
        this.contentView = viewInflate;
        View viewFindViewById = viewInflate.findViewById(R$id.tv_task_title);
        p.h(viewFindViewById, "findViewById(...)");
        this.tvTitle = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R$id.tv_task_desc);
        p.h(viewFindViewById2, "findViewById(...)");
        this.tvDesc = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R$id.tv_task_status);
        p.h(viewFindViewById3, "findViewById(...)");
        this.tvStatus = (TextView) viewFindViewById3;
        setContentView(viewInflate);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setElevation(8.0f);
    }

    public final void a(View anchor, TaskIconInfo task) {
        p.i(anchor, "anchor");
        p.i(task, "task");
        this.tvTitle.setText(task.getTitle());
        this.tvDesc.setText(task.getDescription());
        this.tvStatus.setText("进行中");
        showAsDropDown(anchor, 0, 8);
    }
}
