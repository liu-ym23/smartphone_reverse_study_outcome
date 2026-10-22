package com.bytedance.android.livesdk.unify;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH'JD\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH'JH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'JN\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/unify/IUnifyApi;", "", "doGet", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", "headers", "", "Lcom/bytedance/retrofit2/client/Header;", "query", "", "doGetAsync", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "doPost", "data", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "doPostAsync", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUnifyApi {
    @GET
    Call<TypedInput> doGet(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, String> r102);

    @GET
    Observable<SsResponse<TypedInput>> doGetAsync(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, String> r102);

    @POST
    Call<TypedInput> doPost(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, String> r102, @Body TypedOutput r103);

    @POST
    Observable<SsResponse<TypedInput>> doPostAsync(@Url String r100, @HeaderList List<Header> r101, @QueryMap Map<String, String> r102, @Body TypedOutput r103);
}
